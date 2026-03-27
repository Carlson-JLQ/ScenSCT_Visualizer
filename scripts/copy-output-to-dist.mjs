import fs from "node:fs";
import path from "node:path";

const rootDir = process.cwd();
const outputDir = path.resolve(rootDir, "output");
const distOutputDir = path.resolve(rootDir, "dist", "output");

if (!fs.existsSync(outputDir) || !fs.statSync(outputDir).isDirectory()) {
  console.warn("[build] output directory not found, skipping copy.");
  process.exit(0);
}

fs.mkdirSync(path.dirname(distOutputDir), { recursive: true });
fs.rmSync(distOutputDir, { recursive: true, force: true });
fs.cpSync(outputDir, distOutputDir, { recursive: true });

console.log(`[build] copied output to ${path.relative(rootDir, distOutputDir)}`);
