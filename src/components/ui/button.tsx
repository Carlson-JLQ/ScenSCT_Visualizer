import * as React from "react";
import { cn } from "@/lib/utils";

export type ButtonVariant = "primary" | "ghost" | "outline" | "danger";

export interface ButtonProps
  extends React.ButtonHTMLAttributes<HTMLButtonElement> {
  variant?: ButtonVariant;
  size?: "sm" | "md" | "lg";
}

const variantStyles: Record<ButtonVariant, string> = {
  primary: "bg-ink text-white shadow-sm hover:bg-ink/90 active:scale-[0.98]",
  ghost: "bg-transparent text-ink hover:bg-ink/[0.04] active:bg-ink/[0.06]",
  outline: "border border-ink/10 text-ink hover:border-ink/20 hover:bg-ink/[0.02] active:bg-ink/[0.04]",
  danger: "bg-ember text-white shadow-sm hover:bg-ember/90 active:scale-[0.98]"
};

const sizeStyles = {
  sm: "h-8 px-3 text-xs gap-1.5",
  md: "h-9 px-4 text-sm gap-2",
  lg: "h-11 px-5 text-sm gap-2"
};

const Button = React.forwardRef<HTMLButtonElement, ButtonProps>(
  ({ className, variant = "primary", size = "md", ...props }, ref) => (
    <button
      ref={ref}
      className={cn(
        "inline-flex items-center justify-center rounded-lg font-medium",
        "focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-accent/30 focus-visible:ring-offset-1",
        "disabled:opacity-50 disabled:pointer-events-none",
        "transition-all duration-150",
        variantStyles[variant],
        sizeStyles[size],
        className
      )}
      {...props}
    />
  )
);

Button.displayName = "Button";

export { Button };
