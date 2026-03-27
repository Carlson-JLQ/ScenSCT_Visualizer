import * as React from "react";
import { cn } from "@/lib/utils";

export interface InputProps
  extends React.InputHTMLAttributes<HTMLInputElement> { }

export const Input = React.forwardRef<HTMLInputElement, InputProps>(
  ({ className, ...props }, ref) => (
    <input
      ref={ref}
      className={cn(
        "h-9 w-full rounded-lg border border-ink/10 bg-white px-3 text-sm text-ink placeholder:text-muted/60",
        "focus:outline-none focus:ring-2 focus:ring-accent/20 focus:border-accent/40",
        "transition-all duration-150",
        className
      )}
      {...props}
    />
  )
);

Input.displayName = "Input";
