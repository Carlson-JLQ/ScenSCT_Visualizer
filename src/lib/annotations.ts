import { useMutation, useQuery, useQueryClient } from "@tanstack/react-query";
import { ReportEntry, isExpectedNegativeTest, isExpectedPositiveTest } from "@/lib/reports";
import { fetchToolAnnotations, saveAnnotation, deleteAnnotation, CheckerAnnotations, ToolAnnotations } from "@/lib/api";

export type AnnotationOutcome = "fp" | "tp" | "fn" | "tn" | "unk";

export interface AnnotationRecord {
  outcome: AnnotationOutcome;
  updatedAt: number;
}

// Keep this type compatible with existing consumers (flattening the hierarchical API response)
export type FlatAnnotations = Record<string, AnnotationRecord>;

export function getAnnotationId(tool: string, checker: string, file: string) {
  return `${tool}::${checker}::${file}`;
}

export function getAnnotationProgress(
  entry: ReportEntry,
  annotations?: FlatAnnotations
) {
  const reported = entry.report.report_files;
  const passing = entry.report.pass_files;
  const pendingReported = reported.filter((file) => !isExpectedPositiveTest(file));
  const pendingPassing = passing.filter((file) => !isExpectedNegativeTest(file));
  const total = pendingReported.length + pendingPassing.length;
  const resolved = annotations ?? {};
  const annotated = [...pendingReported, ...pendingPassing].filter((file) => {
    const id = getAnnotationId(entry.tool, entry.checker, file);
    return Boolean(resolved[id]);
  }).length;

  const complete = total === 0 ? true : annotated === total;

  return { total, annotated, complete };
}

// Convert API response (nested) to flat record for easier consumption by components
function flattenToolAnnotations(tool: string, data: ToolAnnotations): FlatAnnotations {
  const flat: FlatAnnotations = {};
  for (const [checker, outcomes] of Object.entries(data)) {
    // outcomes is CheckerAnnotations { fp: [], ... }
    const validOutcomes: AnnotationOutcome[] = ["fp", "tp", "fn", "tn", "unk"];
    for (const outcome of validOutcomes) {
      if (outcomes[outcome]) {
        for (const entry of outcomes[outcome]) {
          const id = getAnnotationId(tool, checker, entry.filePath);
          flat[id] = { outcome, updatedAt: entry.updatedAt };
        }
      }
    }
  }
  return flat;
}

export function useAnnotations(tool: string) {
  return useQuery({
    queryKey: ["annotations", tool],
    queryFn: () => fetchToolAnnotations(tool),
    select: (data) => flattenToolAnnotations(tool, data),
    staleTime: 0, // Always refetch on window focus
    refetchInterval: 10000, // Poll every 10 seconds for side-by-side windows
  });
}

export function useUpdateAnnotation(tool: string) {
  const queryClient = useQueryClient();

  return useMutation({
    mutationFn: (variables: { checker: string; file: string; outcome: AnnotationOutcome }) =>
      saveAnnotation(tool, variables.checker, variables.file, variables.outcome),
    onMutate: async (newAnnotation) => {
      await queryClient.cancelQueries({ queryKey: ["annotations", tool] });

      const previousAnnotations = queryClient.getQueryData(["annotations", tool]);

      // Optimistic update
      queryClient.setQueryData(["annotations", tool], (old: ToolAnnotations | undefined) => {
        const newData = JSON.parse(JSON.stringify(old || {}));
        const { checker, file, outcome } = newAnnotation;

        if (!newData[checker]) {
          newData[checker] = { fp: [], tp: [], fn: [], tn: [], unk: [] };
        }

        // Remove from other lists
        const outcomes: AnnotationOutcome[] = ["fp", "tp", "fn", "tn", "unk"];
        outcomes.forEach(k => {
          if (newData[checker][k]) {
            newData[checker][k] = newData[checker][k].filter((e: any) => e.filePath !== file);
          }
        });

        // Add to new list
        if (!newData[checker][outcome]) newData[checker][outcome] = [];
        newData[checker][outcome].push({ filePath: file, updatedAt: Date.now() });

        return newData;
      });

      return { previousAnnotations };
    },
    onError: (err, newAnnotation, context) => {
      if (context?.previousAnnotations) {
        queryClient.setQueryData(["annotations", tool], context.previousAnnotations);
      }
    },
    onSettled: () => {
      queryClient.invalidateQueries({ queryKey: ["annotations", tool] });
    },
  });
}

export function useDeleteAnnotation(tool: string) {
  const queryClient = useQueryClient();

  return useMutation({
    mutationFn: (variables: { checker: string; file: string }) =>
      deleteAnnotation(tool, variables.checker, variables.file),
    onMutate: async (target) => {
      await queryClient.cancelQueries({ queryKey: ["annotations", tool] });
      const previousAnnotations = queryClient.getQueryData(["annotations", tool]);

      // Optimistic update
      queryClient.setQueryData(["annotations", tool], (old: ToolAnnotations | undefined) => {
        const newData = JSON.parse(JSON.stringify(old || {}));
        const { checker, file } = target;

        if (newData[checker]) {
          const outcomes: AnnotationOutcome[] = ["fp", "tp", "fn", "tn", "unk"];
          outcomes.forEach(k => {
            if (newData[checker][k]) {
              newData[checker][k] = newData[checker][k].filter((e: any) => e.filePath !== file);
            }
          });
        }
        return newData;
      });
      return { previousAnnotations };
    },
    onError: (err, variables, context) => {
      if (context?.previousAnnotations) {
        queryClient.setQueryData(["annotations", tool], context.previousAnnotations);
      }
    },
    onSettled: () => {
      queryClient.invalidateQueries({ queryKey: ["annotations", tool] });
    },
  });
}
