import { defineConfig } from "vite";
import react from "@vitejs/plugin-react";
import path from "node:path";
import fs from "node:fs";
function collectReports() {
    var outputDir = path.resolve(__dirname, "output");
    var entries = [];
    if (!fs.existsSync(outputDir)) {
        return entries;
    }
    var tools = fs.readdirSync(outputDir);
    for (var _i = 0, tools_1 = tools; _i < tools_1.length; _i++) {
        var tool = tools_1[_i];
        var toolDir = path.join(outputDir, tool);
        if (!fs.statSync(toolDir).isDirectory())
            continue;
        var checkers = fs.readdirSync(toolDir);
        for (var _a = 0, checkers_1 = checkers; _a < checkers_1.length; _a++) {
            var checker = checkers_1[_a];
            var checkerDir = path.join(toolDir, checker);
            if (!fs.statSync(checkerDir).isDirectory())
                continue;
            var reportPath = path.join(checkerDir, "report.json");
            var metadataPath = path.join(checkerDir, "metadata.json");
            if (!fs.existsSync(reportPath) || !fs.statSync(reportPath).isFile()) {
                continue;
            }
            try {
                var raw = fs.readFileSync(reportPath, "utf8");
                var report = JSON.parse(raw);
                var metadata = void 0;
                if (fs.existsSync(metadataPath) && fs.statSync(metadataPath).isFile()) {
                    try {
                        var metaRaw = fs.readFileSync(metadataPath, "utf8");
                        var parsed = JSON.parse(metaRaw);
                        metadata = {
                            checker_id: parsed.checker_id,
                            checker_desc: parsed.checker_desc
                        };
                    }
                    catch (error) {
                        console.warn("[visualizer] Failed to read ".concat(metadataPath, ":"), error);
                    }
                }
                entries.push({
                    tool: tool,
                    checker: checker,
                    report: report,
                    metadata: metadata,
                    sourcePath: reportPath
                });
            }
            catch (error) {
                console.warn("[visualizer] Failed to read ".concat(reportPath, ":"), error);
            }
        }
    }
    return entries;
}
function attachOutputMiddleware(server, outputDir) {
    server.middlewares.use("/output", function (req, res, next) {
        var _a;
        var urlPath = ((_a = req.url) === null || _a === void 0 ? void 0 : _a.replace(/^\/output/, "")) || "";
        var fsPath = path.join(outputDir, urlPath);
        var safe = fsPath.startsWith(outputDir);
        if (!safe || !fs.existsSync(fsPath) || fs.statSync(fsPath).isDirectory()) {
            return next();
        }
        var ext = path.extname(fsPath);
        var contentType = ext === ".json"
            ? "application/json"
            : ext === ".java"
                ? "text/x-java-source"
                : "text/plain; charset=utf-8";
        res.setHeader("Content-Type", contentType);
        fs.createReadStream(fsPath).pipe(res);
    });
}
import Database from "better-sqlite3";
function attachAnnotationSaveMiddleware(server, outputDir) {
    // Ensure directory
    var cacheDir = path.join(outputDir, ".cache");
    if (!fs.existsSync(cacheDir)) {
        fs.mkdirSync(cacheDir, { recursive: true });
    }
    // Initialize DB
    var dbPath = path.join(cacheDir, "annotations.sqlite");
    var db = new Database(dbPath);
    db.pragma("journal_mode = WAL");
    // Create table
    db.exec("\n    CREATE TABLE IF NOT EXISTS annotations (\n      tool TEXT NOT NULL,\n      checker TEXT NOT NULL,\n      file_path TEXT NOT NULL,\n      outcome TEXT NOT NULL,\n      updated_at INTEGER NOT NULL,\n      PRIMARY KEY (tool, checker, file_path)\n    );\n    CREATE INDEX IF NOT EXISTS idx_tool ON annotations(tool);\n  ");
    // Prepared statements
    var stmtSelect = db.prepare("\n    SELECT checker, file_path as filePath, outcome, updated_at as updatedAt \n    FROM annotations \n    WHERE tool = ?\n  ");
    var stmtUpsert = db.prepare("\n    INSERT OR REPLACE INTO annotations (tool, checker, file_path, outcome, updated_at)\n    VALUES (@tool, @checker, @filePath, @outcome, @updatedAt)\n  ");
    var stmtDelete = db.prepare("\n    DELETE FROM annotations \n    WHERE tool = @tool AND checker = @checker AND file_path = @filePath\n  ");
    // GET /api/annotations?tool=name
    server.middlewares.use("/api/annotations", function (req, res, next) {
        var url = new URL(req.url || "", "http://localhost");
        if (url.pathname !== "/")
            return next();
        if (req.method !== "GET") {
            res.statusCode = 405;
            res.end(JSON.stringify({ error: "Method not allowed" }));
            return;
        }
        var tool = url.searchParams.get("tool");
        if (!tool) {
            res.statusCode = 400;
            res.end(JSON.stringify({ error: "Missing tool param" }));
            return;
        }
        try {
            var rows = stmtSelect.all(tool);
            var data = {};
            var outcomes = ["fp", "tp", "fn", "tn", "unk"];
            for (var _i = 0, rows_1 = rows; _i < rows_1.length; _i++) {
                var row = rows_1[_i];
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
        }
        catch (e) {
            console.error(e);
            res.statusCode = 500;
            res.end(JSON.stringify({ error: "DB Error" }));
        }
    });
    // POST /api/annotation
    server.middlewares.use("/api/annotation", function (req, res, next) {
        if (req.url !== "/")
            return next();
        if (req.method !== "POST") {
            res.statusCode = 405;
            res.end(JSON.stringify({ error: "Method not allowed" }));
            return;
        }
        var body = "";
        req.on("data", function (chunk) { return body += chunk; });
        req.on("end", function () {
            try {
                var payload = JSON.parse(body);
                var tool = payload.tool, checker = payload.checker, filePath = payload.file, outcome = payload.outcome, updatedAt = payload.updatedAt, action = payload.action;
                if (!tool || !checker || !filePath) {
                    res.statusCode = 400;
                    res.end(JSON.stringify({ error: "Missing fields" }));
                    return;
                }
                if (action === "delete") {
                    stmtDelete.run({ tool: tool, checker: checker, filePath: filePath });
                }
                else {
                    stmtUpsert.run({
                        tool: tool,
                        checker: checker,
                        filePath: filePath,
                        outcome: outcome,
                        updatedAt: updatedAt || Date.now()
                    });
                }
                res.setHeader("Content-Type", "application/json");
                res.end(JSON.stringify({ success: true }));
            }
            catch (e) {
                console.error(e);
                res.statusCode = 500;
                res.end(JSON.stringify({ error: "DB Error" }));
            }
        });
    });
}
function shouldIgnoreWatch(filePath) {
    var normalized = filePath.split(path.sep).join("/");
    if (normalized.includes("/output/")) {
        return !normalized.endsWith("/report.json") && !normalized.endsWith("/metadata.json");
    }
    return false;
}
export default defineConfig({
    plugins: [
        react(),
        {
            name: "report-manifest",
            resolveId: function (id) {
                if (id === "virtual:report-data") {
                    return "\0virtual:report-data";
                }
            },
            load: function (id) {
                if (id === "\0virtual:report-data") {
                    var reports = collectReports();
                    var watchedPaths = reports.map(function (entry) { return entry.sourcePath; });
                    for (var _i = 0, watchedPaths_1 = watchedPaths; _i < watchedPaths_1.length; _i++) {
                        var file = watchedPaths_1[_i];
                        this.addWatchFile(file);
                    }
                    return "export default ".concat(JSON.stringify(reports), ";");
                }
            }
        },
        {
            name: "serve-output-folder",
            configureServer: function (server) {
                var outputDir = path.resolve(__dirname, "output");
                attachOutputMiddleware(server, outputDir);
                attachAnnotationSaveMiddleware(server, outputDir);
            },
            configurePreviewServer: function (server) {
                var outputDir = path.resolve(__dirname, "output");
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
            ignored: shouldIgnoreWatch
        }
    }
});
