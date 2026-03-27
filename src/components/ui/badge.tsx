import * as React from "react";
import { cn } from "@/lib/utils";

export interface BadgeProps extends React.HTMLAttributes<HTMLSpanElement> {
  tone?: "neutral" | "positive" | "negative" | "warn" | "info";
}

const toneStyles = {
  neutral: "bg-ink/[0.06] text-ink/70",
  positive: "bg-moss/10 text-moss",
  negative: "bg-ember/10 text-ember",
  warn: "bg-amber/10 text-amber",
  info: "bg-sky/10 text-sky"
};

export const Badge = React.forwardRef<HTMLSpanElement, BadgeProps>(
  ({ className, tone = "neutral", ...props }, ref) => (
    <span
      ref={ref}
      className={cn(
        "inline-flex items-center rounded-md px-2 py-0.5 text-xs font-medium",
        toneStyles[tone],
        className
      )}
      {...props}
    />
  )
);

Badge.displayName = "Badge";
