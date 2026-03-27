const STORAGE_KEY = "scensct:selected-tool";

export function getSelectedTool(): string | null {
    if (typeof window === "undefined") {
        return null;
    }
    return window.localStorage.getItem(STORAGE_KEY);
}

export function setSelectedTool(tool: string) {
    window.localStorage.setItem(STORAGE_KEY, tool);
}
