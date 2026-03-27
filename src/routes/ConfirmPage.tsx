import { useEffect, useMemo, useRef, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { Panel, PanelGroup, PanelResizeHandle } from "react-resizable-panels";
import { Button } from "@/components/ui/button";
import { Card } from "@/components/ui/card";
import { ConfirmDialog } from "@/components/ui/confirm-dialog";
import { Segmented, SegmentedItem } from "@/components/ui/segmented";
import { Badge } from "@/components/ui/badge";
import { CodeViewer } from "@/components/CodeViewer";
import { DiffCodeViewer } from "@/components/DiffCodeViewer";
import {
  extractFileName,
  getReport,
  getReports,
  isExpectedNegativeTest,
  isExpectedPositiveTest,
  type ReportEntry
} from "@/lib/reports";
import {
  getAnnotationId,
  getAnnotationProgress,
  useAnnotations,
  useUpdateAnnotation,
  useDeleteAnnotation,
  type AnnotationOutcome
} from "@/lib/annotations";
import { cn } from "@/lib/utils";
import { fetchSource } from "@/lib/source";
import { getSelectedTool, setSelectedTool } from "@/lib/toolState";
import { isVariantTest, getOriginalTestPathFromFile } from "@/lib/testVariant";

interface ConfirmCase {
  file: string;
  status: "reported" | "passing";
}

function buildConfirmCases(entry: ReportEntry, mode: "fp" | "fn") {
  const files =
    mode === "fp"
      ? entry.report.report_files.filter((file) => !isExpectedPositiveTest(file))
      : entry.report.pass_files.filter((file) => !isExpectedNegativeTest(file));
  const status = mode === "fp" ? "reported" : "passing" as const;
  return files.map((file) => ({ file, status }));
}

const outcomeStyles = {
  fp: {
    backgroundColor: "rgba(245, 158, 11, 0.1)",
    color: "#f59e0b",
    borderColor: "rgba(245, 158, 11, 0.25)"
  },
  fn: {
    backgroundColor: "rgba(239, 68, 68, 0.1)",
    color: "#ef4444",
    borderColor: "rgba(239, 68, 68, 0.25)"
  },
  tp: {
    backgroundColor: "rgba(59, 130, 246, 0.1)",
    color: "#3b82f6",
    borderColor: "rgba(59, 130, 246, 0.25)"
  },
  tn: {
    backgroundColor: "rgba(34, 197, 94, 0.1)",
    color: "#22c55e",
    borderColor: "rgba(34, 197, 94, 0.25)"
  },
  unk: {
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

export function ConfirmPage() {
  const params = useParams();
  const navigate = useNavigate();
  const entries = getReports();
  const allTools = useMemo(
    () => Array.from(new Set(entries.map((entry) => entry.tool))),
    [entries]
  );

  const [tool, setToolState] = useState(() => {
    const fromUrl = params.tool;
    const saved = getSelectedTool();
    return fromUrl ?? (saved && allTools.includes(saved) ? saved : allTools[0] ?? "");
  });

  const { data: annotations = {} } = useAnnotations(tool);

  const [onlyPending, setOnlyPending] = useState(false);
  const filteredEntries = useMemo(
    () =>
      onlyPending
        ? entries.filter((entry) => !getAnnotationProgress(entry, annotations).complete)
        : entries,
    [entries, onlyPending, annotations]
  );

  const handleSetTool = (t: string) => {
    setToolState(t);
    setSelectedTool(t);
  };
  const [checker, setChecker] = useState(params.checker ?? "");
  const [mode, setMode] = useState<"fp" | "fn">("fp");
  const [index, setIndex] = useState(0);
  const [summary, setSummary] = useState("");
  const rightColumnRef = useRef<HTMLDivElement>(null);
  const [leftPanelHeight, setLeftPanelHeight] = useState<number | null>(null);
  const [showDiff, setShowDiff] = useState(false);
  const [customOriginalPath, setCustomOriginalPath] = useState<string | null>(null);
  const [diffViewMode, setDiffViewMode] = useState<"unified" | "split">("unified");
  const [diffShowLines, setDiffShowLines] = useState(true);
  const [showTestCases, setShowTestCases] = useState(true);

  const checkersForTool = useMemo(
    () =>
      filteredEntries
        .filter((item) => item.tool === tool)
        .map((item) => item.checker),
    [filteredEntries, tool]
  );
  const pendingEntries = useMemo(
    () => entries.filter((entry) => entry.tool === tool && !getAnnotationProgress(entry, annotations).complete),
    [entries, annotations, tool]
  );

  const resolvedChecker = checker || "";

  const entry = useMemo(() => {
    if (!tool || !resolvedChecker) {
      return undefined;
    }
    return (
      filteredEntries.find(
        (item) => item.tool === tool && item.checker === resolvedChecker
      ) || getReport(tool, resolvedChecker)
    );
  }, [tool, resolvedChecker, filteredEntries]);

  const cases = useMemo(() => {
    if (!entry) {
      return [] as ConfirmCase[];
    }
    return buildConfirmCases(entry, mode);
  }, [entry, mode]);

  const activeCase = cases[index];
  const progress = entry ? getAnnotationProgress(entry, annotations) : undefined;
  const annotation = activeCase && annotations
    ? annotations[getAnnotationId(entry!.tool, entry!.checker, activeCase.file)]
    : undefined;

  // Compute if current test is a variant and its original path
  const currentFileName = activeCase?.file ?? "";
  const isCurrentVariant = isVariantTest(currentFileName);
  const autoOriginalPath = isCurrentVariant ? getOriginalTestPathFromFile(currentFileName) : null;
  // Check if auto-detected original exists in file list
  const autoOriginalExists = autoOriginalPath && entry && (
    entry.report.report_files.some((f) => f.includes(autoOriginalPath)) ||
    entry.report.pass_files.some((f) => f.includes(autoOriginalPath))
  );
  // For variant tests with existing original, default to auto-detected; otherwise require manual selection
  const originalPath = customOriginalPath ?? (autoOriginalExists ? autoOriginalPath : null);

  // Get original test status (look in both report/pass files)
  const originalStatus = useMemo(() => {
    if (!entry || !originalPath) return undefined;
    if (entry.report.report_files.some((f) => f.includes(originalPath))) return "reported" as const;
    if (entry.report.pass_files.some((f) => f.includes(originalPath))) return "passing" as const;
    return undefined;
  }, [entry, originalPath]);

  // Reset diff mode when test changes
  useEffect(() => {
    setShowDiff(false);
    setCustomOriginalPath(null);
  }, [activeCase?.file]);
  useEffect(() => {
    if (!allTools.includes(tool)) {
      handleSetTool(allTools[0] ?? "");
      setChecker("");
      setIndex(0);
    }
  }, [allTools, tool]);
  useEffect(() => {
    if (resolvedChecker && !checkersForTool.includes(resolvedChecker)) {
      setChecker("");
      setIndex(0);
    }
  }, [checkersForTool, resolvedChecker]);

  const updateAnnotation = useUpdateAnnotation(tool);
  const deleteAnnotation = useDeleteAnnotation(tool);

  const handleAnnotate = (outcome: AnnotationOutcome) => {
    if (!entry || !activeCase) {
      return;
    }
    // const id = getAnnotationId(entry.tool, entry.checker, activeCase.file);
    if (annotation?.outcome === outcome) {
      deleteAnnotation.mutate({ checker: entry.checker, file: activeCase.file });
    } else {
      updateAnnotation.mutate({ checker: entry.checker, file: activeCase.file, outcome });
    }
  };



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

  const markerStyle = mode === "fp" ? outcomeStyles.fp : outcomeStyles.fn;

  return (
    <div className="flex flex-col gap-5 pb-12">
      <Card>
        <div className="flex flex-wrap items-center gap-3">
          <select
            className="h-9 rounded-lg border border-ink/10 bg-white pl-3 pr-8 text-sm text-ink focus:outline-none focus:ring-2 focus:ring-accent/20"
            value={tool}
            onChange={(event) => {
              const nextTool = event.target.value;
              handleSetTool(nextTool);
              setChecker("");
              setIndex(0);
            }}
          >
            {allTools.map((toolName) => (
              <option key={toolName} value={toolName}>
                {toolName}
              </option>
            ))}
          </select>
          <select
            className="h-9 rounded-lg border border-ink/10 bg-white pl-3 pr-8 text-sm text-ink focus:outline-none focus:ring-2 focus:ring-accent/20"
            value={resolvedChecker}
            onChange={(event) => {
              setChecker(event.target.value);
              setIndex(0);
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
                setChecker("");
                setIndex(0);
              }}
            />
            Only unannotated
          </label>
          <div className="flex-1" />
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
                  {progress?.annotated ?? 0} / {progress?.total ?? 0} annotated
                </span>
                <Badge
                  tone={progress?.complete ? "positive" : "warn"}
                >
                  {progress?.complete ? "Complete" : "In progress"}
                </Badge>
              </div>
            </div>
            <div className="flex flex-wrap items-center gap-2">
              <Button
                variant="outline"
                onClick={() => navigate(`/checker/${entry.tool}/${entry.checker}`)}
              >
                View Tests
              </Button>
              <Button variant="primary">Annotate</Button>
            </div>
          </div>
        </Card>
      ) : entries.length === 0 ? (
        <Card>
          <div className="text-sm text-muted">No reports found.</div>
        </Card>
      ) : onlyPending && !resolvedChecker ? (
        <Card>
          <div className="text-sm text-muted">
            {pendingEntries.length === 0
              ? "🎉 All checkers have been annotated!"
              : `📋 ${pendingEntries.length} checkers need annotation.`}
          </div>
        </Card>
      ) : (
        <Card>
          <div className="text-sm text-muted">Select a checker to continue.</div>
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
                    active={mode === "fp"}
                    className={mode === "fp" ? "!bg-ink !text-white" : ""}
                    onClick={() => {
                      setMode("fp");
                      setIndex(0);
                    }}
                  >
                    Reported
                  </SegmentedItem>
                  <SegmentedItem
                    active={mode === "fn"}
                    className={mode === "fn" ? "!bg-ink !text-white" : ""}
                    onClick={() => {
                      setMode("fn");
                      setIndex(0);
                    }}
                  >
                    Passing
                  </SegmentedItem>
                </Segmented>
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
                  {cases.length === 0 ? 0 : index + 1} / {cases.length}
                </span>
                <Button
                  size="sm"
                  variant="outline"
                  onClick={() =>
                    setIndex((prev) => Math.min(prev + 1, cases.length - 1))
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
                        style={mode === "fp" ? outcomeStyles.P : outcomeStyles.N}
                      >
                        {mode === "fp" ? "reported" : "passing"}
                      </span>
                    </div>
                    <div className="flex min-h-0 flex-1 flex-col gap-2 overflow-y-auto pr-1">
                      {cases.length === 0 ? (
                        <div className="text-sm text-muted">
                          No test cases to review.
                        </div>
                      ) : (
                        cases.map((testCase, idx) => {
                          const id = getAnnotationId(entry.tool, entry.checker, testCase.file);
                          const ann = annotations[id];
                          let badgeStyle = null;
                          let badgeText = null;
                          if (ann) {
                            badgeText = ann.outcome.toUpperCase();
                            badgeStyle = outcomeStyles[ann.outcome as keyof typeof outcomeStyles] ?? null;
                          }
                          return (
                            <button
                              key={testCase.file}
                              className={cn(
                                "flex items-center justify-between gap-2 rounded-lg border px-3 py-2 text-left transition-all",
                                idx === index
                                  ? "border-accent/30 bg-accent/[0.06] ring-1 ring-accent/20"
                                  : "border-ink/[0.06] bg-white hover:border-ink/10 hover:bg-ink/[0.02]"
                              )}
                              onClick={() => setIndex(idx)}
                            >
                              <span className="text-sm font-medium text-ink truncate">
                                {extractFileName(testCase.file)}
                              </span>
                              {badgeText && badgeStyle ? (
                                <span
                                  className="rounded-md border px-2 py-0.5 text-xs font-medium flex-shrink-0"
                                  style={badgeStyle}
                                >
                                  {badgeText}
                                </span>
                              ) : (
                                <span className="w-8 flex-shrink-0" />
                              )}
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
                      <h3 className="font-semibold text-ink">Annotate</h3>
                      <p className="text-sm text-muted mt-0.5">
                        {activeCase ? activeCase.file : "Select a test case."}
                      </p>
                      {summary && (
                        <p className="mt-2 text-sm text-ink">
                          <span className="font-medium">Scenario:</span>{" "}
                          <span className="text-muted">{summary}</span>
                        </p>
                      )}
                    </div>
                    {activeCase && (
                      <div className="flex items-center gap-3">
                        <Button
                          size="sm"
                          variant="outline"
                          className={cn(
                            (annotation?.outcome === "fp" || annotation?.outcome === "fn") && "ring-2",
                            mode === "fp"
                              ? "hover:border-amber hover:text-amber"
                              : "hover:border-ember hover:text-ember",
                            annotation?.outcome === (mode === "fp" ? "fp" : "fn") &&
                            (mode === "fp"
                              ? "ring-amber/30 border-amber text-amber bg-amber/10"
                              : "ring-ember/30 border-ember text-ember bg-ember/10")
                          )}
                          onClick={() => handleAnnotate(mode === "fp" ? "fp" : "fn")}
                        >
                          {mode === "fp" ? "FP" : "FN"}
                        </Button>
                        <Button
                          size="sm"
                          variant="outline"
                          className={cn(
                            (annotation?.outcome === "tp" || annotation?.outcome === "tn") && "ring-2",
                            mode === "fp"
                              ? "hover:border-sky hover:text-sky"
                              : "hover:border-moss hover:text-moss",
                            annotation?.outcome === (mode === "fp" ? "tp" : "tn") &&
                            (mode === "fp"
                              ? "ring-sky/30 border-sky text-sky bg-sky/10"
                              : "ring-moss/30 border-moss text-moss bg-moss/10")
                          )}
                          onClick={() => handleAnnotate(mode === "fp" ? "tp" : "tn")}
                        >
                          {mode === "fp" ? "TP" : "TN"}
                        </Button>
                        <Button
                          size="sm"
                          variant="outline"
                          className={cn(
                            "hover:border-muted hover:text-muted",
                            annotation?.outcome === "unk" &&
                            "ring-2 ring-muted/30 border-muted text-muted bg-muted/10"
                          )}
                          onClick={() => handleAnnotate("unk")}
                        >
                          UNK
                        </Button>

                      </div>
                    )}
                    {activeCase && (
                      <Button
                        size="sm"
                        className={cn(
                          "bg-ink text-white hover:bg-ink/90",
                          showDiff && "ring-2 ring-ink/30"
                        )}
                        onClick={() => setShowDiff((v) => !v)}
                      >
                        {showDiff ? "Hide Diff" : "Show Diff"}
                      </Button>
                    )}
                  </div>
                  {showDiff && activeCase && (
                    <div className="mt-4 pt-4 border-t border-ink/[0.06]">
                      <div className="flex items-center justify-between gap-4 flex-wrap">
                        <div className="flex items-center gap-2">
                          <span className="text-sm text-muted">Comparing with:</span>
                          <select
                            className="h-8 rounded-lg border border-ink/10 bg-white pl-2 pr-6 text-sm text-ink focus:outline-none focus:ring-2 focus:ring-accent/20"
                            value={originalPath ?? ""}
                            onChange={(e) => setCustomOriginalPath(e.target.value || null)}
                          >
                            <option value="">
                              {isCurrentVariant && autoOriginalPath ? `Auto: ${extractFileName(autoOriginalPath)}` : "Select a test..."}
                            </option>
                            {isCurrentVariant && autoOriginalPath && (
                              <option value={autoOriginalPath}>
                                {extractFileName(autoOriginalPath)}
                              </option>
                            )}
                            {entry && [...entry.report.report_files, ...entry.report.pass_files]
                              .filter((f) => f !== currentFileName && f !== autoOriginalPath)
                              .map((f) => (
                                <option key={f} value={f}>
                                  {extractFileName(f)}
                                </option>
                              ))}
                          </select>
                        </div>
                        <div className="flex items-center gap-3">
                          <label className="flex items-center gap-1.5 text-xs text-muted cursor-pointer">
                            <input
                              type="checkbox"
                              className="h-3.5 w-3.5 rounded border-ink/20 accent-accent"
                              checked={diffShowLines}
                              onChange={(e) => setDiffShowLines(e.target.checked)}
                            />
                            Lines
                          </label>
                          <div className="flex rounded-md border border-ink/10 overflow-hidden">
                            <button
                              className={cn(
                                "px-2 py-1 text-xs font-medium transition-colors",
                                diffViewMode === "unified" ? "bg-ink text-white" : "bg-white text-muted hover:bg-ink/5"
                              )}
                              onClick={() => setDiffViewMode("unified")}
                            >
                              Unified
                            </button>
                            <button
                              className={cn(
                                "px-2 py-1 text-xs font-medium transition-colors border-l border-ink/10",
                                diffViewMode === "split" ? "bg-ink text-white" : "bg-white text-muted hover:bg-ink/5"
                              )}
                              onClick={() => setDiffViewMode("split")}
                            >
                              Split
                            </button>
                          </div>
                        </div>
                      </div>
                    </div>
                  )}
                </Card>
                {activeCase ? (
                  showDiff && originalPath ? (
                    <DiffCodeViewer
                      originalPath={originalPath}
                      variantPath={activeCase.file}
                      baseUrl={entry.baseUrl}
                      originalStatus={originalStatus}
                      variantStatus={activeCase.status as "reported" | "passing"}
                      viewMode={diffViewMode}
                      showLineNumbers={diffShowLines}
                    />
                  ) : (
                    <CodeViewer filePath={activeCase.file} baseUrl={entry.baseUrl} />
                  )
                ) : (
                  <Card>
                    <div className="text-sm text-muted">No test selected.</div>
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
