import { AnnotationOutcome } from "./annotations";

function buildApiUrl(pathname: string) {
    const base = import.meta.env.BASE_URL || "/";
    const normalizedBase = base.endsWith("/") ? base : `${base}/`;
    const normalizedPath = pathname.replace(/^\/+/, "");
    return `${normalizedBase}${normalizedPath}`;
}

export interface AnnotationEntry {
    filePath: string;
    updatedAt: number;
}

export interface CheckerAnnotations {
    fp: AnnotationEntry[];
    tp: AnnotationEntry[];
    fn: AnnotationEntry[];
    tn: AnnotationEntry[];
    unk: AnnotationEntry[];
}

export type ToolAnnotations = Record<string, CheckerAnnotations>;

type StaticAnnotations = Record<string, ToolAnnotations>;

async function fetchStaticToolAnnotations(tool: string): Promise<ToolAnnotations> {
    const res = await fetch(buildApiUrl("output/.cache/annotations.json"));
    if (!res.ok) {
        throw new Error(`Failed to fetch static annotations for ${tool}`);
    }
    const payload = (await res.json()) as StaticAnnotations;
    return payload[tool] ?? {};
}

export async function fetchToolAnnotations(tool: string): Promise<ToolAnnotations> {
    const url = buildApiUrl(`api/annotations?tool=${encodeURIComponent(tool)}`);
    try {
        const res = await fetch(url);
        const contentType = res.headers.get("content-type") || "";
        if (!res.ok || contentType.includes("text/html")) {
            return fetchStaticToolAnnotations(tool);
        }
        return res.json();
    } catch {
        return fetchStaticToolAnnotations(tool);
    }
}

export async function saveAnnotation(
    tool: string,
    checker: string,
    file: string,
    outcome: AnnotationOutcome
) {
    const res = await fetch(buildApiUrl("api/annotation"), {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
            tool,
            checker,
            file,
            outcome,
            updatedAt: Date.now(),
            action: "upsert"
        }),
    });
    if (!res.ok) {
        throw new Error("Failed to save annotation");
    }
    return res.json();
}

export async function deleteAnnotation(
    tool: string,
    checker: string,
    file: string
) {
    const res = await fetch(buildApiUrl("api/annotation"), {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
            tool,
            checker,
            file,
            action: "delete"
        }),
    });
    if (!res.ok) {
        throw new Error("Failed to delete annotation");
    }
    return res.json();
}
