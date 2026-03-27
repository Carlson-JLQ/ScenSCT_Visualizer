import { useEffect, useState, useMemo } from "react";
import { fetchSource } from "@/lib/source";
import { cn } from "@/lib/utils";

let highlighterPromise: Promise<{
    codeToHtml: (code: string, options: { lang: string; theme: string }) => string;
}> | null = null;

async function getHighlighter() {
    if (!highlighterPromise) {
        highlighterPromise = Promise.all([
            import("shiki/core"),
            import("shiki/wasm"),
            import("shiki/langs/java.mjs"),
            import("shiki/themes/github-light.mjs")
        ]).then(([{ createHighlighterCore }, getWasm, java, githubLight]) =>
            createHighlighterCore({
                themes: [githubLight.default],
                langs: [java.default],
                loadWasm: getWasm.default
            })
        );
    }
    return highlighterPromise;
}

function escapeHtml(value: string) {
    return value.replace(/&/g, "&amp;").replace(/</g, "&lt;").replace(/>/g, "&gt;");
}

function extractScenario(content: string | null): string {
    if (!content) return "";
    const firstLine = content.split(/\r?\n/).find((line) => line.trim().length > 0) ?? "";
    const trimmed = firstLine.trim();
    if (trimmed.startsWith("//")) return trimmed.replace(/^\/\/\s?/, "").trim();
    if (trimmed.startsWith("#")) return trimmed.replace(/^#\s?/, "").trim();
    return "";
}

function stripLeadingComment(content: string) {
    const lines = content.split(/\r?\n/);
    const firstContentIndex = lines.findIndex((line) => line.trim().length > 0);
    if (firstContentIndex === -1) return content;
    const first = lines[firstContentIndex].trim();
    if (first.startsWith("//") || first.startsWith("#")) lines.splice(firstContentIndex, 1);
    return lines.join("\n");
}

interface DiffLine {
    type: "context" | "add" | "remove";
    content: string;
    html?: string;
    oldLineNum?: number;
    newLineNum?: number;
}

function computeUnifiedDiff(originalLines: string[], variantLines: string[]): DiffLine[] {
    const result: DiffLine[] = [];
    let oi = 0, vi = 0;
    while (oi < originalLines.length || vi < variantLines.length) {
        const origLine = oi < originalLines.length ? originalLines[oi] : null;
        const varLine = vi < variantLines.length ? variantLines[vi] : null;
        if (origLine === varLine) {
            result.push({ type: "context", content: origLine ?? "", oldLineNum: oi + 1, newLineNum: vi + 1 });
            oi++; vi++;
        } else if (origLine !== null && varLine !== null) {
            result.push({ type: "remove", content: origLine, oldLineNum: oi + 1 });
            result.push({ type: "add", content: varLine, newLineNum: vi + 1 });
            oi++; vi++;
        } else if (origLine !== null) {
            result.push({ type: "remove", content: origLine, oldLineNum: oi + 1 });
            oi++;
        } else if (varLine !== null) {
            result.push({ type: "add", content: varLine, newLineNum: vi + 1 });
            vi++;
        }
    }
    return result;
}

interface SourceData {
    content: string | null;
    scenario: string;
    html: string;
    status: "loading" | "ready" | "missing";
}

const statusStyles = {
    reported: { backgroundColor: "rgba(59, 130, 246, 0.08)", color: "#3b82f6", borderColor: "rgba(59, 130, 246, 0.2)" },
    passing: { backgroundColor: "rgba(34, 197, 94, 0.08)", color: "#22c55e", borderColor: "rgba(34, 197, 94, 0.2)" }
};

const CodeIcon = () => (
    <svg className="w-4 h-4 text-muted flex-shrink-0" fill="none" viewBox="0 0 24 24" stroke="currentColor" strokeWidth={1.5}>
        <path strokeLinecap="round" strokeLinejoin="round" d="M17.25 6.75L22.5 12l-5.25 5.25m-10.5 0L1.5 12l5.25-5.25m7.5-3l-4.5 16.5" />
    </svg>
);

interface DiffCodeViewerProps {
    originalPath: string;
    variantPath: string;
    baseUrl?: string;
    originalStatus?: "reported" | "passing";
    variantStatus?: "reported" | "passing";
    viewMode: "unified" | "split";
    showLineNumbers: boolean;
    className?: string;
}

export function DiffCodeViewer({
    originalPath, variantPath, baseUrl, originalStatus, variantStatus, viewMode, showLineNumbers, className
}: DiffCodeViewerProps) {
    const [original, setOriginal] = useState<SourceData>({ content: null, scenario: "", html: "", status: "loading" });
    const [variant, setVariant] = useState<SourceData>({ content: null, scenario: "", html: "", status: "loading" });

    useEffect(() => {
        let alive = true;
        const controller = new AbortController();
        const load = async () => {
            setOriginal((prev) => ({ ...prev, status: "loading" }));
            try {
                const source = await fetchSource(originalPath, baseUrl, { onlyBase: true, signal: controller.signal });
                if (!alive) return;
                if (!source.content) { setOriginal({ content: null, scenario: "", html: "", status: "missing" }); return; }
                const scenario = extractScenario(source.content);
                const processed = stripLeadingComment(source.content);
                const highlighter = await getHighlighter();
                if (!alive) return;
                const html = highlighter.codeToHtml(processed, { lang: "java", theme: "github-light" });
                setOriginal({ content: processed, scenario, html, status: "ready" });
            } catch (error) { if ((error as Error).name !== "AbortError") throw error; }
        };
        load();
        return () => { alive = false; controller.abort(); };
    }, [originalPath, baseUrl]);

    useEffect(() => {
        let alive = true;
        const controller = new AbortController();
        const load = async () => {
            setVariant((prev) => ({ ...prev, status: "loading" }));
            try {
                const source = await fetchSource(variantPath, baseUrl, { onlyBase: true, signal: controller.signal });
                if (!alive) return;
                if (!source.content) { setVariant({ content: null, scenario: "", html: "", status: "missing" }); return; }
                const scenario = extractScenario(source.content);
                const processed = stripLeadingComment(source.content);
                const highlighter = await getHighlighter();
                if (!alive) return;
                const html = highlighter.codeToHtml(processed, { lang: "java", theme: "github-light" });
                setVariant({ content: processed, scenario, html, status: "ready" });
            } catch (error) { if ((error as Error).name !== "AbortError") throw error; }
        };
        load();
        return () => { alive = false; controller.abort(); };
    }, [variantPath, baseUrl]);

    // Parse highlighted HTML to extract line contents
    const parseHtmlLines = (html: string): string[] => {
        // Shiki wraps code in <pre><code>...</code></pre>, extract inner HTML and split by newlines
        const match = html.match(/<code[^>]*>([\s\S]*?)<\/code>/);
        if (!match) return [];
        const inner = match[1];
        // Split by newline, preserving span tags
        return inner.split('\n');
    };

    const diffLines = useMemo(() => {
        if (!original.content || !variant.content) return [];
        return computeUnifiedDiff(original.content.split(/\r?\n/), variant.content.split(/\r?\n/));
    }, [original.content, variant.content]);

    // For unified diff, we need highlighted versions of each line
    const [highlightedDiffLines, setHighlightedDiffLines] = useState<DiffLine[]>([]);

    useEffect(() => {
        if (!original.html || !variant.html || diffLines.length === 0) {
            setHighlightedDiffLines([]);
            return;
        }
        const origHtmlLines = parseHtmlLines(original.html);
        const varHtmlLines = parseHtmlLines(variant.html);

        const result = diffLines.map((line) => {
            let html = escapeHtml(line.content);
            if (line.type === "remove" && line.oldLineNum) {
                html = origHtmlLines[line.oldLineNum - 1] || html;
            } else if (line.type === "add" && line.newLineNum) {
                html = varHtmlLines[line.newLineNum - 1] || html;
            } else if (line.type === "context" && line.oldLineNum) {
                html = origHtmlLines[line.oldLineNum - 1] || html;
            }
            return { ...line, html };
        });
        setHighlightedDiffLines(result);
    }, [original.html, variant.html, diffLines]);

    const originalFileName = originalPath.split("/").pop() || originalPath;
    const variantFileName = variantPath.split("/").pop() || variantPath;
    const isLoading = original.status === "loading" || variant.status === "loading";
    const hasMissing = original.status === "missing" || variant.status === "missing";
    const scenarioDiff = original.scenario !== variant.scenario;

    const origHtmlLines = useMemo(() => parseHtmlLines(original.html), [original.html]);
    const varHtmlLines = useMemo(() => parseHtmlLines(variant.html), [variant.html]);

    return (
        <div className={cn("code-block rounded-2xl border border-ink/[0.06] bg-white shadow-soft overflow-hidden", className)}>
            {/* Scenario section */}
            <div className="px-4 py-2.5 border-b border-ink/[0.06] bg-white">
                {scenarioDiff ? (
                    <div className="flex flex-col gap-1">
                        <div className="flex items-center gap-2 text-sm">
                            <span className="font-medium text-muted w-16">Original:</span>
                            <span className="text-muted bg-ember/10 px-1.5 rounded">{original.scenario || "(empty)"}</span>
                        </div>
                        <div className="flex items-center gap-2 text-sm">
                            <span className="font-medium text-muted w-16">Variant:</span>
                            <span className="text-muted bg-moss/10 px-1.5 rounded">{variant.scenario || "(empty)"}</span>
                        </div>
                    </div>
                ) : (
                    <p className="text-sm text-ink">
                        <span className="font-medium">Scenario:</span>{" "}
                        <span className="text-muted">{original.scenario || variant.scenario || "(none)"}</span>
                    </p>
                )}
            </div>

            {viewMode === "unified" ? (
                <>
                    <div className="flex items-center gap-2 px-4 py-2.5 border-b border-ink/[0.06] bg-haze/50">
                        <CodeIcon />
                        <span className="text-xs font-medium text-muted">{originalFileName}</span>
                        {originalStatus && (
                            <span className="rounded-md border px-1.5 py-0.5 text-[10px] font-medium" style={statusStyles[originalStatus]}>
                                {originalStatus === "reported" ? "Reported" : "Passing"}
                            </span>
                        )}
                        <span className="text-muted mx-1">→</span>
                        <CodeIcon />
                        <span className="text-xs font-medium text-muted">{variantFileName}</span>
                        {variantStatus && (
                            <span className="rounded-md border px-1.5 py-0.5 text-[10px] font-medium" style={statusStyles[variantStatus]}>
                                {variantStatus === "reported" ? "Reported" : "Passing"}
                            </span>
                        )}
                    </div>
                    <div className="p-4 overflow-auto">
                        {isLoading ? (
                            <div className="flex items-center gap-2 text-sm text-muted">
                                <svg className="w-4 h-4 animate-spin" fill="none" viewBox="0 0 24 24">
                                    <circle className="opacity-25" cx="12" cy="12" r="10" stroke="currentColor" strokeWidth="4" />
                                    <path className="opacity-75" fill="currentColor" d="M4 12a8 8 0 018-8V0C5.373 0 0 5.373 0 12h4zm2 5.291A7.962 7.962 0 014 12H0c0 3.042 1.135 5.824 3 7.938l3-2.647z" />
                                </svg>
                                Loading…
                            </div>
                        ) : hasMissing ? (
                            <div className="text-sm text-muted">
                                {original.status === "missing" && <p>Original not found: <code className="px-1 py-0.5 rounded bg-ink/[0.04] text-xs font-mono">{originalPath}</code></p>}
                                {variant.status === "missing" && <p>Variant not found: <code className="px-1 py-0.5 rounded bg-ink/[0.04] text-xs font-mono">{variantPath}</code></p>}
                            </div>
                        ) : (
                            <div className="font-mono text-sm">
                                {highlightedDiffLines.map((line, idx) => (
                                    <div key={idx} className={cn("flex", line.type === "add" && "bg-moss/10", line.type === "remove" && "bg-ember/10")}>
                                        {showLineNumbers && (
                                            <>
                                                <span className="w-10 flex-shrink-0 text-right pr-2 text-muted/50 select-none border-r border-ink/[0.06]">{line.oldLineNum ?? ""}</span>
                                                <span className="w-10 flex-shrink-0 text-right pr-2 text-muted/50 select-none border-r border-ink/[0.06]">{line.newLineNum ?? ""}</span>
                                            </>
                                        )}
                                        <span className={cn("w-5 flex-shrink-0 text-center select-none", line.type === "add" && "text-moss font-bold", line.type === "remove" && "text-ember font-bold", line.type === "context" && "text-muted/30")}>
                                            {line.type === "add" ? "+" : line.type === "remove" ? "-" : " "}
                                        </span>
                                        <span className="flex-1 whitespace-pre-wrap break-all pl-2 [&_span]:!bg-transparent" dangerouslySetInnerHTML={{ __html: line.html || " " }} />
                                    </div>
                                ))}
                            </div>
                        )}
                    </div>
                </>
            ) : (
                <div className="flex">
                    <div className="flex-1 border-r border-ink/[0.06]">
                        <div className="flex items-center gap-2 px-4 py-2.5 border-b border-ink/[0.06] bg-haze/50">
                            <CodeIcon />
                            <span className="text-xs font-medium text-muted">{originalFileName}</span>
                            {originalStatus && (
                                <span className="rounded-md border px-1.5 py-0.5 text-[10px] font-medium" style={statusStyles[originalStatus]}>
                                    {originalStatus === "reported" ? "Reported" : "Passing"}
                                </span>
                            )}
                        </div>
                        <div className="p-4 overflow-auto font-mono text-sm">
                            {isLoading || !original.content ? (
                                <div className="text-sm text-muted">{isLoading ? "Loading…" : "Not found"}</div>
                            ) : (
                                origHtmlLines.map((lineHtml, idx) => (
                                    <div key={idx} className="flex">
                                        {showLineNumbers && <span className="w-8 flex-shrink-0 text-right pr-2 text-muted/50 select-none">{idx + 1}</span>}
                                        <span className="flex-1 whitespace-pre-wrap break-all" dangerouslySetInnerHTML={{ __html: lineHtml || " " }} />
                                    </div>
                                ))
                            )}
                        </div>
                    </div>
                    <div className="flex-1">
                        <div className="flex items-center gap-2 px-4 py-2.5 border-b border-ink/[0.06] bg-haze/50">
                            <CodeIcon />
                            <span className="text-xs font-medium text-muted">{variantFileName}</span>
                            {variantStatus && (
                                <span className="rounded-md border px-1.5 py-0.5 text-[10px] font-medium" style={statusStyles[variantStatus]}>
                                    {variantStatus === "reported" ? "Reported" : "Passing"}
                                </span>
                            )}
                        </div>
                        <div className="p-4 overflow-auto font-mono text-sm">
                            {isLoading || !variant.content ? (
                                <div className="text-sm text-muted">{isLoading ? "Loading…" : "Not found"}</div>
                            ) : (
                                varHtmlLines.map((lineHtml, idx) => (
                                    <div key={idx} className="flex">
                                        {showLineNumbers && <span className="w-8 flex-shrink-0 text-right pr-2 text-muted/50 select-none">{idx + 1}</span>}
                                        <span className="flex-1 whitespace-pre-wrap break-all" dangerouslySetInnerHTML={{ __html: lineHtml || " " }} />
                                    </div>
                                ))
                            )}
                        </div>
                    </div>
                </div>
            )}
        </div>
    );
}
