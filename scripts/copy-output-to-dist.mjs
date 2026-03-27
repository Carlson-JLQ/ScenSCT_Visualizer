import fs from "node:fs";
import path from "node:path";
import Database from "better-sqlite3";

const rootDir = process.cwd();
const outputDir = path.resolve(rootDir, "output");
const distOutputDir = path.resolve(rootDir, "dist", "output");
const annotationsDbPath = path.resolve(outputDir, ".cache", "annotations.sqlite");

function exportAnnotationsJson() {
  if (!fs.existsSync(annotationsDbPath)) {
    console.warn("[build] annotations sqlite not found, skipping annotations export.");
    return;
  }

  const db = new Database(annotationsDbPath, { readonly: true });
  try {
    const rows = db
      .prepare(
        "SELECT tool, checker, file_path AS filePath, outcome, updated_at AS updatedAt FROM annotations"
      )
      .all();

    const payload = {};
    const validOutcomes = new Set(["fp", "tp", "fn", "tn", "unk"]);

    for (const row of rows) {
      if (!validOutcomes.has(row.outcome)) {
        continue;
      }
      if (!payload[row.tool]) {
        payload[row.tool] = {};
      }
      if (!payload[row.tool][row.checker]) {
        payload[row.tool][row.checker] = { fp: [], tp: [], fn: [], tn: [], unk: [] };
      }
      payload[row.tool][row.checker][row.outcome].push({
        filePath: row.filePath,
        updatedAt: row.updatedAt
      });
    }

    const cacheDir = path.resolve(outputDir, ".cache");
    fs.mkdirSync(cacheDir, { recursive: true });
    const outJsonPath = path.resolve(cacheDir, "annotations.json");
    fs.writeFileSync(outJsonPath, JSON.stringify(payload), "utf8");
    console.log(`[build] exported annotations to ${path.relative(rootDir, outJsonPath)}`);
  } finally {
    db.close();
  }
}

if (!fs.existsSync(outputDir) || !fs.statSync(outputDir).isDirectory()) {
  console.warn("[build] output directory not found, skipping copy.");
  process.exit(0);
}

exportAnnotationsJson();

fs.mkdirSync(path.dirname(distOutputDir), { recursive: true });
fs.rmSync(distOutputDir, { recursive: true, force: true });
fs.cpSync(outputDir, distOutputDir, { recursive: true });

console.log(`[build] copied output to ${path.relative(rootDir, distOutputDir)}`);
