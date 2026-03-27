/**
 * Utilities for detecting and parsing variant test file names.
 * Variant tests follow the pattern: (Pos|Neg)Case\d+_(FP|FN|Var)\d+
 */

export interface VariantTestInfo {
    testType: "Pos" | "Neg";
    baseNumber: number;
    variantType: "FP" | "FN" | "Var";
    variantNumber: number;
}

const VARIANT_PATTERN = /^(Pos|Neg)Case(\d+)_(FP|FN|Var)(\d+)\.java$/;

/**
 * Parse a variant test filename to extract its components.
 * @returns VariantTestInfo if matches pattern, null otherwise
 */
export function parseVariantTestName(filename: string): VariantTestInfo | null {
    const basename = filename.split("/").pop() ?? filename;
    const match = basename.match(VARIANT_PATTERN);
    if (!match) return null;

    return {
        testType: match[1] as "Pos" | "Neg",
        baseNumber: parseInt(match[2], 10),
        variantType: match[3] as "FP" | "FN" | "Var",
        variantNumber: parseInt(match[4], 10)
    };
}

/**
 * Check if a filename is a variant test.
 */
export function isVariantTest(filename: string): boolean {
    return parseVariantTestName(filename) !== null;
}

/**
 * Get the original test path for a variant test.
 * Example: NegCase8_FP1.java -> src/main/java/scensct/core/neg/NegCase8.java
 */
export function getOriginalTestPath(info: VariantTestInfo): string {
    const folder = info.testType === "Pos" ? "pos" : "neg";
    const name = `${info.testType}Case${info.baseNumber}.java`;
    return `src/main/java/scensct/core/${folder}/${name}`;
}

/**
 * Get the original test path directly from a variant file path.
 * Returns null if not a variant test.
 */
export function getOriginalTestPathFromFile(filePath: string): string | null {
    const info = parseVariantTestName(filePath);
    if (!info) return null;
    return getOriginalTestPath(info);
}
