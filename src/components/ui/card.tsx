import * as React from "react";
import { cn } from "@/lib/utils";

export const Card = React.forwardRef<HTMLDivElement, React.HTMLAttributes<HTMLDivElement>>(
  ({ className, ...props }, ref) => (
    <div
      ref={ref}
      className={cn(
        "rounded-2xl border border-ink/[0.06] bg-white/90 p-5 shadow-soft backdrop-blur-sm",
        className
      )}
      {...props}
    />
  )
);

Card.displayName = "Card";
