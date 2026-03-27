import * as React from "react";
import { cn } from "@/lib/utils";
import { Button } from "./button";

interface ConfirmDialogProps {
    open: boolean;
    title: string;
    message: string;
    confirmLabel?: string;
    cancelLabel?: string;
    onConfirm: () => void;
    onCancel: () => void;
    loading?: boolean;
}

export function ConfirmDialog({
    open,
    title,
    message,
    confirmLabel = "Confirm",
    cancelLabel = "Cancel",
    onConfirm,
    onCancel,
    loading = false,
}: ConfirmDialogProps) {
    if (!open) return null;

    return (
        <div className="fixed inset-0 z-50 flex items-center justify-center">
            {/* Backdrop */}
            <div
                className="absolute inset-0 bg-ink/40 backdrop-blur-sm"
                onClick={onCancel}
            />
            {/* Dialog */}
            <div className="relative z-10 w-full max-w-md rounded-xl border border-ink/10 bg-white p-6 shadow-2xl">
                <h3 className="text-lg font-semibold text-ink">{title}</h3>
                <p className="mt-2 text-sm text-muted leading-relaxed">{message}</p>
                <div className="mt-6 flex items-center justify-end gap-3">
                    <Button variant="ghost" onClick={onCancel} disabled={loading}>
                        {cancelLabel}
                    </Button>
                    <Button variant="primary" onClick={onConfirm} disabled={loading}>
                        {loading ? "Saving..." : confirmLabel}
                    </Button>
                </div>
            </div>
        </div>
    );
}
