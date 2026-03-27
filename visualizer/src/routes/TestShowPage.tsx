import { useEffect, useMemo, useRef, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { Panel, PanelGroup, PanelResizeHandle } from "react-resizable-panels";
import { Button } from "@/components/ui/button";
import { Card } from "@/components/ui/card";
import { Segmented, SegmentedItem } from "@/components/ui/segmented";
import { Badge } from "@/components/ui/badge";
import { CodeViewer } from "@/components/CodeViewer";
import {
  extractFileName,
  getReport,
  getReports,
  getTools,
  type ReportEntry
} from "@/lib/reports";
import {
  getAnnotationId,
  getAnnotationProgress,
  useAnnotations
} from "@/lib/annotations";
import { cn } from "@/lib/utils";
import { fetchSource } from "@/lib/source";
import { getSelectedTool, setSelectedTool } from "@/lib/toolState";
import { isVariantTest } from "@/lib/testVariant";

interface TestCaseEntry {
  file: string;
  status: "reported" | "passing";
}

function buildTestCases(entry: ReportEntry, mode: "positive" | "negative"): TestCaseEntry[] {
  const files =
    mode === "positive" ? entry.report.report_files : entry.report.pass_files;
  const status = mode === "positive" ? "reported" : "passing" as const;
  return files.map((file) => ({ file, status }));
}

function getOutcomeLabel(
  entry: ReportEntry,
  testCase: TestCaseEntry,
  annotated: boolean,
  annotations: Record<string, { outcome: string }>
) {
  if (!annotated) {
    return testCase.status === "reported" ? "P" : "N";
  }

  const id = getAnnotationId(entry.tool, entry.checker, testCase.file);
  const annotation = annotations[id];
  if (!annotation) {
    return testCase.status === "reported" ? "TP" : "TN";
  }

  // Return the outcome directly (fp, tp, fn, tn, unk)
  return annotation.outcome.toUpperCase();
}

const outcomeStyles: Record<
  string,
  { backgroundColor: string; color: string; borderColor: string }
> = {
  TP: {
    backgroundColor: "rgba(59, 130, 246, 0.1)",
    color: "#3b82f6",
    borderColor: "rgba(59, 130, 246, 0.25)"
  },
  TN: {
    backgroundColor: "rgba(34, 197, 94, 0.1)",
    color: "#22c55e",
    borderColor: "rgba(34, 197, 94, 0.25)"
  },
  FP: {
    backgroundColor: "rgba(245, 158, 11, 0.1)",
    color: "#f59e0b",
    borderColor: "rgba(245, 158, 11, 0.25)"
  },
  FN: {
    backgroundColor: "rgba(239, 68, 68, 0.1)",
    color: "#ef4444",
    borderColor: "rgba(239, 68, 68, 0.25)"
  },
  UNK: {
    backgroundColor: "rgba(100, 116, 139, 0.1)",
    color: "#64748b",
    borderColor: "rgba(100, 116, 139, 0.25)"
  },
  P: {
    backgroundColor: "rgba(59, 130, 246, 0.08)",
    color: "#3b82f6",
    borderColor: "rgba(59, 130, 246, 0.2)"
  },
  N: {
    backgroundColor: "rgba(34, 197, 94, 0.08)",
    color: "#22c55e",
    borderColor: "rgba(34, 197, 94, 0.2)"
  }
};

export function TestShowPage() {
  const { tool, checker } = useParams();
  const navigate = useNavigate();
  const entries = useMemo(() => getReports(), []);
  const tools = useMemo(() => getTools(), []);

  const currentTool = tool ?? getSelectedTool() ?? tools[0] ?? "";
  const { data: annotations = {} } = useAnnotations(currentTool);

  const [onlyPending, setOnlyPending] = useState(false);
  const filteredEntries = useMemo(
    () =>
      onlyPending
        ? entries.filter((entry) => !getAnnotationProgress(entry, annotations).complete)
        : entries,
    [entries, onlyPending, annotations]
  );
  const checkersForTool = useMemo(
    () =>
      filteredEntries
        .filter((item) => item.tool === currentTool)
        .map((item) => item.checker),
    [filteredEntries, currentTool]
  );
  const currentChecker =
    onlyPending && checker && !checkersForTool.includes(checker)
      ? ""
      : checker ?? "";
  const entry = useMemo(() => {
    if (!currentTool || !currentChecker) {
      return undefined;
    }
    if (onlyPending) {
      return filteredEntries.find(
        (item) => item.tool === currentTool && item.checker === currentChecker
      );
    }
    return getReport(currentTool, currentChecker);
  }, [currentTool, currentChecker, onlyPending, filteredEntries]);
  const [mode, setMode] = useState<"positive" | "negative">("positive");
  const [index, setIndex] = useState(0);
  const [summary, setSummary] = useState<string>("");
  const rightColumnRef = useRef<HTMLDivElement>(null);
  const [leftPanelHeight, setLeftPanelHeight] = useState<number | null>(null);
  const [showTestCases, setShowTestCases] = useState(true);
  const [hideVariants, setHideVariants] = useState(false);

  const allTestCases = useMemo(() => {
    if (!entry) return [] as TestCaseEntry[];
    return buildTestCases(entry, mode);
  }, [entry, mode]);

  const testCases = useMemo(() => {
    if (!hideVariants) return allTestCases;
    return allTestCases.filter((tc) => !isVariantTest(tc.file));
  }, [allTestCases, hideVariants]);

  const activeCase = testCases[index];

  useEffect(() => {
    let cancelled = false;
    const controller = new AbortController();
    const loadSummary = async () => {
      if (!entry || !activeCase) {
        setSummary("");
        return;
      }
      let source;
      try {
        source = await fetchSource(activeCase.file, entry.baseUrl, {
          onlyBase: true,
          signal: controller.signal
        });
      } catch (error) {
        if ((error as Error).name === "AbortError") {
          return;
        }
        throw error;
      }
      if (cancelled) return;
      const firstLine =
        source.content?.split(/\r?\n/).find((line) => line.trim().length > 0) ??
        "";
      const trimmed = firstLine.trim();
      if (trimmed.startsWith("//")) {
        setSummary(trimmed.replace(/^\/\/\s?/, "").trim());
      } else if (trimmed.startsWith("#")) {
        setSummary(trimmed.replace(/^#\s?/, "").trim());
      } else {
        setSummary("");
      }
    };
    loadSummary();
    return () => {
      cancelled = true;
      controller.abort();
    };
  }, [activeCase, entry]);

  useEffect(() => {
    const target = rightColumnRef.current;
    if (!target) {
      return;
    }
    const update = () => {
      const next = target.getBoundingClientRect().height;
      setLeftPanelHeight(next > 0 ? next : null);
    };
    update();
    const observer = new ResizeObserver(() => update());
    observer.observe(target);
    return () => observer.disconnect();
  }, [entry]);

  const progress = entry ? getAnnotationProgress(entry, annotations) : undefined;
  const annotated = progress?.complete ?? false;

  return (
    <div className="flex flex-col gap-5 pb-12">
      <Card>
        <div className="flex flex-wrap items-center gap-3">
          <select
            className="h-9 rounded-lg border border-ink/10 bg-white pl-3 pr-8 text-sm text-ink focus:outline-none focus:ring-2 focus:ring-accent/20"
            value={currentTool}
            onChange={(event) => {
              const nextTool = event.target.value;
              setSelectedTool(nextTool);
              navigate(`/checker/${nextTool}`);
            }}
          >
            {tools.map((toolName) => (
              <option key={toolName} value={toolName}>
                {toolName}
              </option>
            ))}
          </select>
          <select
            className="h-9 rounded-lg border border-ink/10 bg-white pl-3 pr-8 text-sm text-ink focus:outline-none focus:ring-2 focus:ring-accent/20"
            value={currentChecker}
            onChange={(event) => {
              const nextChecker = event.target.value;
              if (!nextChecker) {
                navigate(`/checker/${currentTool}`);
                return;
              }
              navigate(`/checker/${currentTool}/${nextChecker}`);
            }}
          >
            <option value="">- Select checker -</option>
            {checkersForTool.map((checkerName) => (
              <option key={checkerName} value={checkerName}>
                {checkerName}
              </option>
            ))}
          </select>
          <label className="flex items-center gap-2 text-sm text-muted cursor-pointer">
            <input
              type="checkbox"
              className="h-4 w-4 rounded border-ink/20 accent-accent"
              checked={onlyPending}
              onChange={(e) => {
                setOnlyPending(e.target.checked);
              }}
            />
            Only unannotated
          </label>
        </div>
      </Card>

      {entry ? (
        <Card>
          <div className="flex flex-wrap items-center justify-between gap-4">
            <div>
              <p className="text-xs font-medium text-muted uppercase tracking-wide">
                {entry.tool}
              </p>
              <h2 className="text-xl font-semibold text-ink mt-1">
                {entry.checker}
              </h2>
              {entry.metadata?.checker_id && (
                <p className="mt-1 text-xs text-muted">
                  ID: {entry.metadata.checker_id}
                </p>
              )}
              {entry.metadata?.checker_desc && (
                <p className="mt-2 text-sm text-ink/80 leading-relaxed">
                  {entry.metadata.checker_desc}
                </p>
              )}
              <div className="flex items-center gap-3 mt-3 text-sm text-muted">
                <span>
                  {entry.report.report_files.length} reported · {entry.report.pass_files.length} passing
                </span>
                <Badge
                  tone={annotated ? "positive" : "warn"}
                >
                  {annotated ? "Annotated" : "Needs review"}
                </Badge>
              </div>
            </div>
            <div className="flex flex-wrap items-center gap-2">
              <Button variant="primary">View Tests</Button>
              <Button
                variant="outline"
                onClick={() => navigate(`/confirm/${entry.tool}/${entry.checker}`)}
              >
                Annotate
              </Button>
            </div>
          </div>
        </Card>
      ) : entries.length === 0 ? (
        <Card>
          <div className="text-sm text-muted">No reports found.</div>
        </Card>
      ) : !currentChecker ? (
        <Card>
          <div className="text-sm text-muted">Select a checker to continue.</div>
        </Card>
      ) : onlyPending ? (
        <Card>
          <div className="text-sm text-muted">
            🎉 All checkers have been annotated.
          </div>
        </Card>
      ) : (
        <Card>
          <div className="text-sm text-muted">Checker not found.</div>
        </Card>
      )}

      {entry && (
        <>
          <Card>
            <div className="flex flex-wrap items-center justify-between gap-4">
              <div className="flex items-center gap-2">
                <button
                  className={cn(
                    "p-1.5 rounded-md transition-colors",
                    showTestCases ? "bg-ink/10 text-ink" : "text-muted hover:text-ink hover:bg-ink/5"
                  )}
                  onClick={() => setShowTestCases((v) => !v)}
                  title={showTestCases ? "Hide test cases" : "Show test cases"}
                >
                  <svg className="w-4 h-4" fill="none" viewBox="0 0 24 24" stroke="currentColor" strokeWidth={1.5}>
                    <path strokeLinecap="round" strokeLinejoin="round" d="M8.25 6.75h12M8.25 12h12m-12 5.25h12M3.75 6.75h.007v.008H3.75V6.75zm.375 0a.375.375 0 11-.75 0 .375.375 0 01.75 0zM3.75 12h.007v.008H3.75V12zm.375 0a.375.375 0 11-.75 0 .375.375 0 01.75 0zm-.375 5.25h.007v.008H3.75v-.008zm.375 0a.375.375 0 11-.75 0 .375.375 0 01.75 0z" />
                  </svg>
                </button>
                <Segmented>
                  <SegmentedItem
                    active={mode === "positive"}
                    className={mode === "positive" ? "!bg-ink !text-white" : ""}
                    onClick={() => {
                      setMode("positive");
                      setIndex(0);
                    }}
                  >
                    Reported
                  </SegmentedItem>
                  <SegmentedItem
                    active={mode === "negative"}
                    className={mode === "negative" ? "!bg-ink !text-white" : ""}
                    onClick={() => {
                      setMode("negative");
                      setIndex(0);
                    }}
                  >
                    Passing
                  </SegmentedItem>
                </Segmented>
                <label className="flex items-center gap-1.5 text-xs text-muted cursor-pointer ml-2">
                  <input
                    type="checkbox"
                    className="h-3.5 w-3.5 rounded border-ink/20 accent-accent"
                    checked={hideVariants}
                    onChange={(e) => {
                      setHideVariants(e.target.checked);
                      setIndex(0);
                    }}
                  />
                  Core only
                </label>
              </div>
              <div className="flex items-center gap-2 text-sm text-muted">
                <Button
                  size="sm"
                  variant="outline"
                  onClick={() => setIndex((prev) => Math.max(prev - 1, 0))}
                >
                  ←
                </Button>
                <span className="min-w-[4rem] text-center">
                  {testCases.length === 0 ? 0 : index + 1} / {allTestCases.length}
                </span>
                <Button
                  size="sm"
                  variant="outline"
                  onClick={() =>
                    setIndex((prev) => Math.min(prev + 1, testCases.length - 1))
                  }
                >
                  →
                </Button>
              </div>
            </div>
          </Card>

          <PanelGroup direction="horizontal" className="items-start">
            {showTestCases && (
              <>
                <Panel defaultSize={25} minSize={15}>
                  <Card
                    className="flex min-h-0 flex-col"
                    style={leftPanelHeight ? { height: leftPanelHeight } : undefined}
                  >
                    <div className="mb-4 flex items-center justify-between">
                      <h3 className="font-semibold text-ink">Test Cases</h3>
                      <span
                        className="rounded-md border px-2 py-0.5 text-xs font-medium"
                        style={mode === "positive" ? outcomeStyles.P : outcomeStyles.N}
                      >
                        {mode === "positive" ? "reported" : "passing"}
                      </span>
                    </div>
                    <div className="flex min-h-0 flex-1 flex-col gap-2 overflow-y-auto pr-1">
                      {testCases.length === 0 ? (
                        <div className="text-sm text-muted">
                          No test cases in this mode.
                        </div>
                      ) : (
                        testCases.map((testCase, idx) => {
                          const label = getOutcomeLabel(entry, testCase, annotated, annotations);
                          const outcomeStyle =
                            outcomeStyles[label] ??
                            {
                              backgroundColor: "rgba(15, 23, 42, 0.05)",
                              color: "#0f172a",
                              borderColor: "rgba(15, 23, 42, 0.12)"
                            };
                          const isActive = idx === index;
                          return (
                            <button
                              key={testCase.file}
                              className={cn(
                                "flex items-center justify-between gap-2 rounded-lg border px-3 py-2 text-left transition-all",
                                isActive
                                  ? "border-accent/30 bg-accent/[0.06] ring-1 ring-accent/20"
                                  : "border-ink/[0.06] bg-white hover:border-ink/10 hover:bg-ink/[0.02]"
                              )}
                              onClick={() => setIndex(idx)}
                            >
                              <span className="text-sm font-medium text-ink truncate">
                                {extractFileName(testCase.file)}
                              </span>
                              <span
                                className="rounded-md border px-2 py-0.5 text-xs font-medium flex-shrink-0"
                                style={outcomeStyle}
                              >
                                {label}
                              </span>
                            </button>
                          );
                        })
                      )}
                    </div>
                  </Card>
                </Panel>
                <PanelResizeHandle className="panel-divider mx-2 w-1 rounded-full" />
              </>
            )}
            <Panel>
              <div ref={rightColumnRef} className="flex flex-col gap-4">
                <Card>
                  <div className="flex flex-wrap items-center justify-between gap-4">
                    <div>
                      <h3 className="font-semibold text-ink">Details</h3>
                      <div className="flex items-center gap-2 mt-0.5">
                        <p className="text-sm text-muted">
                          {activeCase ? activeCase.file : "Select a test case."}
                        </p>
                        {activeCase && (
                          <span
                            className="rounded-md border px-1.5 py-0.5 text-[10px] font-medium"
                            style={activeCase.status === "reported" ? outcomeStyles.P : outcomeStyles.N}
                          >
                            {activeCase.status === "reported" ? "Reported" : "Passing"}
                          </span>
                        )}
                      </div>
                    </div>
                    {activeCase && (
                      <span
                        className="rounded-md border px-2.5 py-1 text-sm font-medium"
                        style={
                          outcomeStyles[
                          getOutcomeLabel(entry, activeCase, annotated, annotations)
                          ] || {
                            backgroundColor: "rgba(15,23,42,0.05)",
                            color: "#0f172a",
                            borderColor: "rgba(15,23,42,0.12)"
                          }
                        }
                      >
                        {getOutcomeLabel(entry, activeCase, annotated, annotations)}
                      </span>
                    )}
                  </div>
                  {summary && (
                    <p className="mt-3 text-sm text-ink">
                      <span className="font-medium">Scenario:</span>{" "}
                      <span className="text-muted">{summary}</span>
                    </p>
                  )}
                </Card>
                {activeCase ? (
                  <CodeViewer filePath={activeCase.file} baseUrl={entry.baseUrl} />
                ) : (
                  <Card>
                    <div className="text-sm text-muted">
                      No test selected.
                    </div>
                  </Card>
                )}
              </div>
            </Panel>
          </PanelGroup>
        </>
      )}
    </div>
  );
}
