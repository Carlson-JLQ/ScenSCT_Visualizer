import * as React from "react";
import { cn } from "@/lib/utils";

interface SegmentedProps extends React.HTMLAttributes<HTMLDivElement> { }

export function Segmented({ className, ...props }: SegmentedProps) {
  return (
    <div
      className={cn(
        "inline-flex items-center gap-1 rounded-lg bg-ink/[0.04] p-1",
        className
      )}
      {...props}
    />
  );
}

interface SegmentedItemProps
  extends React.ButtonHTMLAttributes<HTMLButtonElement> {
  active?: boolean;
}

export function SegmentedItem({
  active,
  className,
  ...props
}: SegmentedItemProps) {
  return (
    <button
      className={cn(
        "rounded-md px-3 py-1.5 text-sm font-medium transition-all duration-150",
        active
          ? "bg-white text-ink shadow-sm"
          : "text-muted hover:text-ink",
        className
      )}
      {...props}
    />
  );
}
