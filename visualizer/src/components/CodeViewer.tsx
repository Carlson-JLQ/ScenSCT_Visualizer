import { useEffect, useState } from "react";
import { fetchSource } from "@/lib/source";

let highlighterPromise: Promise<{
  codeToHtml: (code: string, options: { lang: string; theme: string }) => string;
}> | null = null;

const MAX_HIGHLIGHT_CHARS = 200_000;

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

function stripLeadingComment(content: string) {
  const lines = content.split(/\r?\n/);
  const firstContentIndex = lines.findIndex((line) => line.trim().length > 0);
  if (firstContentIndex === -1) return content;
  const first = lines[firstContentIndex].trim();
  if (first.startsWith("//") || first.startsWith("#")) {
    lines.splice(firstContentIndex, 1);
  }
  return lines.join("\n");
}

function escapeHtml(value: string) {
  return value
    .replace(/&/g, "&amp;")
    .replace(/</g, "&lt;")
    .replace(/>/g, "&gt;");
}

function scheduleIdle(task: () => void) {
  if (typeof window !== "undefined" && "requestIdleCallback" in window) {
    return window.requestIdleCallback(task);
  }
  return setTimeout(task, 0) as unknown as number;
}

function cancelIdle(handle: number) {
  if (typeof window !== "undefined" && "cancelIdleCallback" in window) {
    window.cancelIdleCallback(handle);
  } else {
    clearTimeout(handle);
  }
}

interface CodeViewerProps {
  filePath: string;
  baseUrl?: string;
  language?: string;
  className?: string;
}

export function CodeViewer({
  filePath,
  baseUrl,
  language = "java",
  className
}: CodeViewerProps) {
  const [html, setHtml] = useState<string>("");
  const [status, setStatus] = useState<"idle" | "loading" | "missing">(
    "idle"
  );

  useEffect(() => {
    let alive = true;
    const controller = new AbortController();
    let idleHandle: number | null = null;

    const load = async () => {
      setStatus("loading");
      let source;
      try {
        source = await fetchSource(filePath, baseUrl, {
          onlyBase: true,
          signal: controller.signal
        });
      } catch (error) {
        if ((error as Error).name === "AbortError") {
          return;
        }
        throw error;
      }
      if (!alive) {
        return;
      }
      if (!source.content) {
        setStatus("missing");
        const baseLabel = baseUrl ?? "";
        const fileLabel = filePath.startsWith("/") ? filePath : `/${filePath}`;
        setHtml(
          `<div class="text-sm text-muted">Source not found at <code class="px-1 py-0.5 rounded bg-ink/[0.04] text-xs font-mono">${baseLabel}${fileLabel}</code></div>`
        );
        return;
      }
      const processed = stripLeadingComment(source.content);
      if (processed.length > MAX_HIGHLIGHT_CHARS) {
        setStatus("idle");
        setHtml(
          `<pre class="whitespace-pre-wrap font-mono text-sm">${escapeHtml(processed)}</pre>`
        );
        return;
      }
      idleHandle = scheduleIdle(async () => {
        if (!alive) {
          return;
        }
        const highlighter = await getHighlighter();
        if (!alive) {
          return;
        }
        const highlighted = highlighter.codeToHtml(processed, {
          lang: language,
          theme: "github-light"
        });
        setStatus("idle");
        setHtml(highlighted);
      });
    };

    load();

    return () => {
      alive = false;
      controller.abort();
      if (idleHandle !== null) {
        cancelIdle(idleHandle);
      }
    };
  }, [filePath, baseUrl, language]);

  const fileName = filePath.split("/").pop() || filePath;

  return (
    <div
      className={`code-block rounded-2xl border border-ink/[0.06] bg-white shadow-soft overflow-hidden ${className ?? ""}`}
    >
      <div className="flex items-center gap-2 px-4 py-2.5 border-b border-ink/[0.06] bg-haze/50">
        <svg className="w-4 h-4 text-muted" fill="none" viewBox="0 0 24 24" stroke="currentColor" strokeWidth={1.5}>
          <path strokeLinecap="round" strokeLinejoin="round" d="M17.25 6.75L22.5 12l-5.25 5.25m-10.5 0L1.5 12l5.25-5.25m7.5-3l-4.5 16.5" />
        </svg>
        <span className="text-xs font-medium text-muted truncate">{fileName}</span>
      </div>
      <div className="p-4">
        {status === "loading" ? (
          <div className="flex items-center gap-2 text-sm text-muted">
            <svg className="w-4 h-4 animate-spin" fill="none" viewBox="0 0 24 24">
              <circle className="opacity-25" cx="12" cy="12" r="10" stroke="currentColor" strokeWidth="4" />
              <path className="opacity-75" fill="currentColor" d="M4 12a8 8 0 018-8V0C5.373 0 0 5.373 0 12h4zm2 5.291A7.962 7.962 0 014 12H0c0 3.042 1.135 5.824 3 7.938l3-2.647z" />
            </svg>
            Loading source…
          </div>
        ) : (
          <div
            className="text-sm leading-relaxed [&_pre]:overflow-x-auto"
            dangerouslySetInnerHTML={{ __html: html }}
          />
        )}
      </div>
    </div>
  );
}
