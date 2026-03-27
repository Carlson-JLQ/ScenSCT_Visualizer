// If condition with non-trivial constant analysis (range), not increment/overflow type, then branch is a throw (not ConcurrentModificationException).
package scensct.var.pos;

public class PosCase7_Var5 {
    // Variant 5: Use a final variable, negate the condition with a boolean wrapper
    public static void main(String[] args) {
        final int limit = 200;
        int y = 100;
        boolean ok = y <= limit; // Always true // [REPORTED LINE]
        if (!ok) { // Always false
            throw new IllegalArgumentException("y too large");
        }
    }
}