// A recognized format method call with format string having undetermined max specifier index should not be flagged.
package scensct.var.neg;

public class NegCase7_Var2 {
    public static void main(String[] args) {
        // Variant 2: Intra-procedural refactoring - use temporary for argument, add no-effect control flow
        Object arg = "world";
        if (System.currentTimeMillis() > 0) {
            String result = String.format("Hello %", arg);
        }
    }
}