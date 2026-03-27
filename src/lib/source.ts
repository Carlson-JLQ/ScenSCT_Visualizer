export interface SourceResult {
  content: string | null;
  resolvedUrl?: string;
}

export interface FetchSourceOptions {
  onlyBase?: boolean;
  signal?: AbortSignal;
}

function buildPublicBase(pathname: string) {
  const base = import.meta.env.BASE_URL || "/";
  const normalizedBase = base.endsWith("/") ? base : `${base}/`;
  const normalizedPath = pathname.replace(/^\/+/, "");
  return `${normalizedBase}${normalizedPath}`;
}

const CANDIDATE_BASES = [
  buildPublicBase("/"),
  buildPublicBase("/tests/"),
  buildPublicBase("/data/"),
  buildPublicBase("/output/")
];

export async function fetchSource(
  filePath: string,
  baseUrl?: string,
  options: FetchSourceOptions = {}
): Promise<SourceResult> {
  const normalized = filePath.replace(/^\/+/, "");
  const bases = baseUrl
    ? options.onlyBase
      ? [baseUrl]
      : [baseUrl, ...CANDIDATE_BASES]
    : CANDIDATE_BASES;
  for (const base of bases) {
    const baseNormalized = base.endsWith("/") ? base : `${base}/`;
    const url = `${baseNormalized}${normalized}`;
    try {
      const response = await fetch(url, { signal: options.signal });
      const contentType = response.headers.get("content-type") || "";
      if (!response.ok || contentType.includes("text/html")) {
        continue;
      }
      const text = await response.text();
      if (/^\s*<!doctype html/i.test(text)) {
        continue;
      }
      return { content: text, resolvedUrl: url };
    } catch (error) {
      if ((error as Error).name === "AbortError") {
        throw error;
      }
      // Ignore and try next base.
    }
  }
  return { content: null };
}
