// A recognized format method call with format string having undetermined max specifier index should not be flagged.
package scensct.var.neg;

public class NegCase7_Var5 {
    public static void main(String[] args) {
        // Variant 5: Control-flow restructuring with try-catch, preserving the malformed specifier
        try {
            String result = String.format("Hello %", args.length > 0 ? args[0] : "world");
        } catch (Exception e) {
            // Swallow exception to keep execution silent
        }
    }
}