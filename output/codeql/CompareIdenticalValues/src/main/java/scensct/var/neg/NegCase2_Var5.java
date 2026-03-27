// Using arithmetic addition operator should not be flagged as identical operand comparison.
package scensct.var.neg;

public class NegCase2_Var5 {
    public static void main(String[] args) {
        int p = 3;
        int q = 7;
        // Variant 5: Wrap operations in a try-catch-finally block (control flow restructuring)
        try {
            int sum = p + q;
            int diff = p - q;
            int prod = p * q;
            int quot = p / q; // Potential division by zero? No, q=7 is safe.
            int and = p & q;
            int or = p | q;
            int xor = p ^ q;
            p = q;
        } catch (Exception e) {
            // Ignore, but no comparisons here either
        } finally {
            // Still no comparisons
        }
    }
}