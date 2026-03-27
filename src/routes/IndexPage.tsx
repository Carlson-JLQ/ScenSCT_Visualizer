import { useMemo, useState } from "react";
import { useNavigate } from "react-router-dom";
import {
  Bar,
  BarChart,
  Legend,
  ResponsiveContainer,
  Tooltip,
  XAxis,
  YAxis
} from "recharts";
import { Button } from "@/components/ui/button";
import { Card } from "@/components/ui/card";
import { Input } from "@/components/ui/input";
import { Badge } from "@/components/ui/badge";
import {
  getReports,
  getTools,
  type ReportEntry
} from "@/lib/reports";
import {
  getAnnotationId,
  getAnnotationProgress,
  useAnnotations,
  type AnnotationRecord
} from "@/lib/annotations";
import { getSelectedTool, setSelectedTool } from "@/lib/toolState";

function buildChartData(
  entries: ReportEntry[],
  annotations: Record<string, AnnotationRecord>
) {
  return entries.map((entry) => {
    const progress = getAnnotationProgress(entry, annotations);
    const reported = entry.report.report_files;
    const passing = entry.report.pass_files;

    if (progress.complete) {
      let TP = 0;
      let TN = 0;
      let FP = 0;
      let FN = 0;
      let UNK = 0;

      for (const file of reported) {
        const id = getAnnotationId(entry.tool, entry.checker, file);
        const outcome = annotations[id]?.outcome;
        if (outcome === "fp") {
          FP += 1;
        } else if (outcome === "unk") {
          UNK += 1;
        } else {
          TP += 1; // Reported but not FP -> TP
        }
      }

      for (const file of passing) {
        const id = getAnnotationId(entry.tool, entry.checker, file);
        const outcome = annotations[id]?.outcome;
        if (outcome === "fn") {
          FN += 1;
        } else if (outcome === "unk") {
          UNK += 1;
        } else {
          TN += 1; // Passing but not FN -> TN
        }
      }

      return {
        checker: entry.checker,
        TP,
        TN,
        FP,
        FN,
        UNK,
        mode: "annotated"
      };
    }

    return {
      checker: entry.checker,
      P: reported.length,
      N: passing.length,
      mode: "raw"
    };
  });
}

function CheckerAxisTick({ x, y, payload, annotatedMap, onNavigate }: any) {
  const label = payload?.value ?? "";
  const annotated = annotatedMap?.get(label);
  const dotColor = annotated ? "#8b5cf6" : "#f59e0b";

  return (
    <g transform={`translate(${x},${y})`}>
      <foreignObject
        x={-500}
        y={-12}
        width={500}
        height={24}
        style={{ overflow: "visible" }}
      >
        <div
          style={{
            display: "flex",
            justifyContent: "flex-end",
            alignItems: "center",
            height: "100%",
            paddingRight: 4,
          }}
        >
          <div
            onClick={() => onNavigate?.(label)}
            style={{
              display: "inline-flex",
              alignItems: "center",
              gap: 8,
              padding: "0 10px",
              height: 24,
              borderRadius: 6,
              background: "white",
              border: "1px solid rgba(15,23,42,0.08)",
              cursor: "pointer",
              whiteSpace: "nowrap",
            }}
          >
            <span
              style={{
                width: 6,
                height: 6,
                borderRadius: "50%",
                background: dotColor,
                flexShrink: 0,
              }}
            />
            <span
              style={{
                fontSize: 13,
                fontWeight: 500,
                color: "#0f172a",
              }}
            >
              {label}
            </span>
          </div>
        </div>
      </foreignObject>
    </g>
  );
}

function CheckerTooltip({ active, payload }: any) {
  if (!active || !payload?.length) {
    return null;
  }
  const data = payload[0].payload;
  return (
    <div className="rounded-xl border border-ink/[0.06] bg-white p-3 text-xs shadow-medium">
      <div className="mb-2 font-semibold text-ink">{data.checker}</div>
      {Object.entries(data)
        .filter(([key]) => key !== "checker" && key !== "mode")
        .map(([key, value]) => (
          <div key={key} className="flex items-center justify-between gap-6">
            <span className="text-muted">{key}</span>
            <span className="font-semibold text-ink">{value as number}</span>
          </div>
        ))}
    </div>
  );
}

export function IndexPage() {
  const navigate = useNavigate();
  const tools = useMemo(() => getTools(), []);
  const [tool, setToolState] = useState(() => {
    const saved = getSelectedTool();
    return saved && tools.includes(saved) ? saved : tools[0] ?? "";
  });

  const { data: annotations = {} } = useAnnotations(tool);
  const setTool = (t: string) => {
    setToolState(t);
    setSelectedTool(t);
  };
  const [checkerInput, setCheckerInput] = useState("");

  const toolEntries = useMemo(
    () => getReports().filter((entry) => entry.tool === tool),
    [tool]
  );



  const chartData = useMemo(
    () => buildChartData(toolEntries, annotations),
    [toolEntries, annotations]
  );
  const annotatedMap = useMemo(() => {
    const map = new Map<string, boolean>();
    toolEntries.forEach((entry) => {
      map.set(entry.checker, getAnnotationProgress(entry, annotations).complete);
    });
    return map;
  }, [toolEntries, annotations]);
  const chartHeight = useMemo(
    () => Math.max(280, toolEntries.length * 40),
    [toolEntries.length]
  );
  const axisWidth = useMemo(() => {
    const longestLen = toolEntries.reduce(
      (max, entry) => Math.max(max, entry.checker.length),
      0
    );
    // Estimate: ~8px per char + padding for dot and spacing
    return Math.max(80, longestLen * 8 + 40);
  }, [toolEntries]);

  const handleNavigate = (checker: string) => {
    if (!tool || !checker) {
      return;
    }
    navigate(`/checker/${tool}/${checker}`);
  };

  return (
    <div className="flex flex-col gap-5">
      <Card>
        <div className="flex flex-wrap items-center justify-between gap-4">
          <div>
            <p className="text-xs font-medium text-muted mb-2">Select tool</p>
            <select
              className="h-9 rounded-lg border border-ink/10 bg-white pl-3 pr-8 text-sm text-ink focus:outline-none focus:ring-2 focus:ring-accent/20 focus:border-accent/40"
              value={tool}
              onChange={(event) => setTool(event.target.value)}
            >
              {tools.map((toolName) => (
                <option key={toolName} value={toolName}>
                  {toolName}
                </option>
              ))}
            </select>
          </div>
          <div className="flex items-center gap-2">
            <Input
              placeholder="Jump to checker…"
              className="w-100"
              value={checkerInput}
              onChange={(event) => setCheckerInput(event.target.value)}
              onKeyDown={(e) => e.key === "Enter" && handleNavigate(checkerInput)}
            />
            <Button
              variant="outline"
              onClick={() => handleNavigate(checkerInput)}
            >
              Go
            </Button>
          </div>
        </div>
      </Card>

      <Card className="min-h-[400px]">
        <div className="mb-5 flex items-center justify-between">
          <div>
            <h2 className="text-lg font-semibold text-ink">
              Checker Coverage
            </h2>
            <p className="text-sm text-muted mt-0.5">
              P/N counts until annotation, then TP/TN/FP/FN breakdown
            </p>
          </div>
          <Badge tone="info">{toolEntries.length} checkers</Badge>
        </div>
        <div style={{ height: chartHeight }}>
          {toolEntries.length === 0 ? (
            <div className="flex h-full items-center justify-center text-sm text-muted">
              No report.json found for this tool.
            </div>
          ) : (
            <ResponsiveContainer width="100%" height="100%">
              <BarChart
                data={chartData}
                layout="vertical"
                margin={{ top: 10, right: 20, left: 10, bottom: 10 }}
                barCategoryGap={14}
                barGap={2}
              >
                <XAxis type="number" tick={{ fontSize: 11, fill: "#64748b" }} axisLine={false} tickLine={false} />
                <YAxis
                  type="category"
                  dataKey="checker"
                  width={axisWidth}
                  tick={
                    <CheckerAxisTick
                      annotatedMap={annotatedMap}
                      onNavigate={handleNavigate}
                    />
                  }
                  axisLine={false}
                  tickLine={false}
                />
                <Tooltip content={<CheckerTooltip />} cursor={{ fill: "rgba(99,102,241,0.04)" }} />
                <Legend wrapperStyle={{ fontSize: 12, color: "#64748b" }} />
                <Bar dataKey="P" stackId="all" fill="#93c5fd" radius={[0, 4, 4, 0]} onClick={(data) => handleNavigate(data.checker)} />
                <Bar dataKey="N" stackId="all" fill="#bbf7d0" radius={[0, 4, 4, 0]} onClick={(data) => handleNavigate(data.checker)} />
                <Bar dataKey="TP" stackId="all" fill="#3b82f6" radius={[0, 4, 4, 0]} onClick={(data) => handleNavigate(data.checker)} />
                <Bar dataKey="TN" stackId="all" fill="#22c55e" radius={[0, 4, 4, 0]} onClick={(data) => handleNavigate(data.checker)} />
                <Bar dataKey="FP" stackId="all" fill="#f59e0b" radius={[0, 4, 4, 0]} onClick={(data) => handleNavigate(data.checker)} />
                <Bar dataKey="FN" stackId="all" fill="#ef4444" radius={[0, 4, 4, 0]} onClick={(data) => handleNavigate(data.checker)} />
                <Bar dataKey="UNK" stackId="all" fill="#cbd5e1" radius={[0, 4, 4, 0]} onClick={(data) => handleNavigate(data.checker)} />
              </BarChart>
            </ResponsiveContainer>
          )}
        </div>
      </Card>
    </div>
  );
}
