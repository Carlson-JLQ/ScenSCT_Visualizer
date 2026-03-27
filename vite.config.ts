import { defineConfig } from "vite";
import react from "@vitejs/plugin-react";
import path from "node:path";
import fs from "node:fs";
import type { ViteDevServer, PreviewServer } from "vite";

interface RawReportEntry {
  tool: string;
  checker: string;
  report: unknown;
  metadata?: {
    checker_id?: string;
    checker_desc?: string;
  };
  sourcePath: string;
}

function collectReports(): RawReportEntry[] {
  const outputDir = path.resolve(__dirname, "output");
  const entries: RawReportEntry[] = [];

  if (!fs.existsSync(outputDir)) {
    return entries;
  }

  const tools = fs.readdirSync(outputDir);
  for (const tool of tools) {
    const toolDir = path.join(outputDir, tool);
    if (!fs.statSync(toolDir).isDirectory()) continue;

    const checkers = fs.readdirSync(toolDir);
    for (const checker of checkers) {
      const checkerDir = path.join(toolDir, checker);
      if (!fs.statSync(checkerDir).isDirectory()) continue;

      const reportPath = path.join(checkerDir, "report.json");
      const metadataPath = path.join(checkerDir, "metadata.json");
      if (!fs.existsSync(reportPath) || !fs.statSync(reportPath).isFile()) {
        continue;
      }

      try {
        const raw = fs.readFileSync(reportPath, "utf8");
        const report = JSON.parse(raw);
        let metadata: RawReportEntry["metadata"];
        if (fs.existsSync(metadataPath) && fs.statSync(metadataPath).isFile()) {
          try {
            const metaRaw = fs.readFileSync(metadataPath, "utf8");
            const parsed = JSON.parse(metaRaw) as {
              checker_id?: string;
              checker_desc?: string;
            };
            metadata = {
              checker_id: parsed.checker_id,
              checker_desc: parsed.checker_desc
            };
          } catch (error) {
            console.warn(`[visualizer] Failed to read ${metadataPath}:`, error);
          }
        }
        entries.push({
          tool,
          checker,
          report,
          metadata,
          sourcePath: reportPath
        });
      } catch (error) {
        console.warn(`[visualizer] Failed to read ${reportPath}:`, error);
      }
    }
  }

  return entries;
}

function attachOutputMiddleware(
  server: ViteDevServer | PreviewServer,
  outputDir: string
) {
  server.middlewares.use("/output", (req, res, next) => {
    const urlPath = (req.url?.split("?")[0] || "").replace(/^\/output/, "");
    const relativePath = urlPath.replace(/^\/+/, "");
    const fsPath = path.resolve(outputDir, relativePath);
    const safe = fsPath === outputDir || fsPath.startsWith(`${outputDir}${path.sep}`);
    if (!safe || !fs.existsSync(fsPath) || fs.statSync(fsPath).isDirectory()) {
      return next();
    }
    const ext = path.extname(fsPath);
    const contentType =
      ext === ".json"
        ? "application/json"
        : ext === ".java"
          ? "text/x-java-source"
          : "text/plain; charset=utf-8";
    res.setHeader("Content-Type", contentType);
    fs.createReadStream(fsPath).pipe(res);
  });
}

interface AnnotationPayload {
  tool: string;
  annotations: Record<string, { confirmed_fps: string[]; confirmed_fns: string[] }>;
}

import Database from "better-sqlite3";

function attachAnnotationSaveMiddleware(
  server: ViteDevServer | PreviewServer,
  outputDir: string
) {
  // Ensure directory
  const cacheDir = path.join(outputDir, ".cache");
  if (!fs.existsSync(cacheDir)) {
    fs.mkdirSync(cacheDir, { recursive: true });
  }

  // Initialize DB
  const dbPath = path.join(cacheDir, "annotations.sqlite");
  console.log(`[SQLite] Initializing database at: ${dbPath}`);

  try {
    const db = new Database(dbPath);
    db.pragma("journal_mode = WAL");
    console.log("[SQLite] Database initialized successfully");

    // Create table
    db.exec(`
      CREATE TABLE IF NOT EXISTS annotations (
        tool TEXT NOT NULL,
        checker TEXT NOT NULL,
        file_path TEXT NOT NULL,
        outcome TEXT NOT NULL,
        updated_at INTEGER NOT NULL,
        PRIMARY KEY (tool, checker, file_path)
      );
      CREATE INDEX IF NOT EXISTS idx_tool ON annotations(tool);
    `);
    console.log("[SQLite] Schema created successfully");

    // Prepared statements
    const stmtSelect = db.prepare<string, { checker: string; filePath: string; outcome: string; updatedAt: number }>(`
      SELECT checker, file_path as filePath, outcome, updated_at as updatedAt 
      FROM annotations 
      WHERE tool = ?
    `);

    const stmtUpsert = db.prepare<{ tool: string; checker: string; filePath: string; outcome: string; updatedAt: number }>(`
      INSERT OR REPLACE INTO annotations (tool, checker, file_path, outcome, updated_at)
      VALUES (@tool, @checker, @filePath, @outcome, @updatedAt)
    `);

    const stmtDelete = db.prepare<{ tool: string; checker: string; filePath: string }>(`
      DELETE FROM annotations 
      WHERE tool = @tool AND checker = @checker AND file_path = @filePath
    `);

    // GET /api/annotations?tool=name
    server.middlewares.use("/api/annotations", (req, res, next) => {
      const url = new URL(req.url || "", "http://localhost");
      if (url.pathname !== "/") return next();
      if (req.method !== "GET") {
        res.statusCode = 405;
        res.end(JSON.stringify({ error: "Method not allowed" }));
        return;
      }
      const tool = url.searchParams.get("tool");
      if (!tool) {
        res.statusCode = 400;
        res.end(JSON.stringify({ error: "Missing tool param" }));
        return;
      }

      try {
        const rows = stmtSelect.all(tool);
        const data: any = {};
        const outcomes = ["fp", "tp", "fn", "tn", "unk"];

        for (const row of rows) {
          if (!data[row.checker]) {
            data[row.checker] = { fp: [], tp: [], fn: [], tn: [], unk: [] };
          }
          if (outcomes.includes(row.outcome)) {
            data[row.checker][row.outcome].push({
              filePath: row.filePath,
              updatedAt: row.updatedAt
            });
          }
        }
        res.setHeader("Content-Type", "application/json");
        res.end(JSON.stringify(data));
      } catch (e) {
        console.error(e);
        res.statusCode = 500;
        res.end(JSON.stringify({ error: "DB Error" }));
      }
    });

    // POST /api/annotation
    server.middlewares.use("/api/annotation", (req, res, next) => {
      if (req.url !== "/") return next();
      if (req.method !== "POST") {
        res.statusCode = 405;
        res.end(JSON.stringify({ error: "Method not allowed" }));
        return;
      }

      let body = "";
      req.on("data", chunk => body += chunk);
      req.on("end", () => {
        try {
          const payload = JSON.parse(body);
          const { tool, checker, file: filePath, outcome, updatedAt, action } = payload;

          if (!tool || !checker || !filePath) {
            res.statusCode = 400;
            res.end(JSON.stringify({ error: "Missing fields" }));
            return;
          }

          if (action === "delete") {
            stmtDelete.run({ tool, checker, filePath });
          } else {
            stmtUpsert.run({
              tool,
              checker,
              filePath,
              outcome,
              updatedAt: updatedAt || Date.now()
            });
          }
          res.setHeader("Content-Type", "application/json");
          res.end(JSON.stringify({ success: true }));
        } catch (e) {
          console.error(e);
          res.statusCode = 500;
          res.end(JSON.stringify({ error: "DB Error" }));
        }
      });
    });
  } catch (error) {
    console.error("[SQLite] Failed to initialize database:", error);
    throw error;
  }
}

export default defineConfig({
  plugins: [
    react(),
    {
      name: "report-manifest",
      resolveId(id) {
        if (id === "virtual:report-data") {
          return "\0virtual:report-data";
        }
      },
      load(id) {
        if (id === "\0virtual:report-data") {
          const reports = collectReports();
          const watchedPaths = reports.map((entry) => entry.sourcePath);
          for (const file of watchedPaths) {
            this.addWatchFile(file);
          }
          return `export default ${JSON.stringify(reports)};`;
        }
      }
    },
    {
      name: "serve-output-folder",
      configureServer(server) {
        const outputDir = path.resolve(__dirname, "output");
        attachOutputMiddleware(server, outputDir);
        attachAnnotationSaveMiddleware(server, outputDir);
      },
      configurePreviewServer(server) {
        const outputDir = path.resolve(__dirname, "output");
        attachOutputMiddleware(server, outputDir);
        attachAnnotationSaveMiddleware(server, outputDir);
      }
    }
  ],
  resolve: {
    alias: {
      "@": path.resolve(__dirname, "./src")
    }
  },
  server: {
    fs: {
      allow: [".."]
    },
    watch: {
      usePolling: true,
      interval: 1000,
      // Ignore everything in the parent project directory.
      // Vite's root is visualizer/, so its own source files are
      // watched by default. Individual report.json files outside
      // the root are still watched via addWatchFile() in the
      // report-manifest plugin.
      ignored: [
        "**/node_modules/**",
        "**/.git/**",
        path.resolve(__dirname, "..") + "/*/**",
      ]
    }
  }
});
