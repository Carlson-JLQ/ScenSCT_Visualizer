import { AnnotationOutcome } from "./annotations";

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

export async function fetchToolAnnotations(tool: string): Promise<ToolAnnotations> {
    const res = await fetch(`/api/annotations?tool=${encodeURIComponent(tool)}`);
    if (!res.ok) {
        throw new Error(`Failed to fetch annotations for ${tool}`);
    }
    return res.json();
}

export async function saveAnnotation(
    tool: string,
    checker: string,
    file: string,
    outcome: AnnotationOutcome
) {
    const res = await fetch("/api/annotation", {
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
    const res = await fetch("/api/annotation", {
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
