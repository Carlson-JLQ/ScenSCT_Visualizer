// If condition with non-trivial constant analysis (range), not increment/overflow type, then branch is a throw (not ConcurrentModificationException).
package scensct.var.pos;

public class PosCase7_Var2 {
    // Variant 2: Use a temporary variable with arithmetic, wrap in try-catch
    public static void main(String[] args) {
        int base = 50;
        int y = base * 2; // Still 100
        try {
            if (y > 200) { // Always false // [REPORTED LINE]
                throw new IllegalArgumentException("y too large");
            }
        } catch (RuntimeException e) {
            // Never reached
            throw e;
        }
    }
}