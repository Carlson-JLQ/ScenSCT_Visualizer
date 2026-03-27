export interface ReportData {
  status: boolean;
  report_files: string[];
  pass_files: string[];
}

export interface ReportEntry {
  tool: string;
  checker: string;
  report: ReportData;
  metadata?: {
    checker_id?: string;
    checker_desc?: string;
  };
  sourcePath: string;
  baseUrl: string;
}

import reportManifest from "virtual:report-data";

function buildPublicPath(pathname: string) {
  const base = import.meta.env.BASE_URL || "/";
  const normalizedBase = base.endsWith("/") ? base : `${base}/`;
  const normalizedPath = pathname.replace(/^\/+/, "");
  return `${normalizedBase}${normalizedPath}`;
}

const reportEntries: ReportEntry[] = (reportManifest as any[]).map((entry) => ({
  tool: entry.tool,
  checker: entry.checker,
  report: entry.report as ReportData,
  metadata: entry.metadata,
  sourcePath: entry.sourcePath,
  baseUrl: buildPublicPath(`output/${entry.tool}/${entry.checker}/`)
}));

export function getReports() {
  return reportEntries;
}

export function getTools() {
  return Array.from(new Set(reportEntries.map((entry) => entry.tool)));
}

export function getReport(tool: string, checker: string) {
  return reportEntries.find(
    (entry) => entry.tool === tool && entry.checker === checker
  );
}

export function getCheckers(tool: string) {
  return reportEntries
    .filter((entry) => entry.tool === tool)
    .map((entry) => entry.checker);
}

export function extractFileName(file: string) {
  const parts = file.split("/");
  return parts[parts.length - 1] ?? file;
}

export function isExpectedPositiveTest(file: string) {
  return /PosCase/i.test(extractFileName(file));
}

export function isExpectedNegativeTest(file: string) {
  return /NegCase/i.test(extractFileName(file));
}

export function splitTestCases(report: ReportData) {
  return {
    reportPos: report.report_files,
    reportNeg: [],
    passPos: [],
    passNeg: report.pass_files
  };
}
