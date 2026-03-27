// If condition with non-trivial constant analysis (range), not increment/overflow type, then branch is a throw (not ConcurrentModificationException).
package scensct.var.pos;

public class PosCase7_Var3 {
    // Variant 3: Loop that does not change the relevant variable, condition inside
    public static void main(String[] args) {
        int y = 100;
        for (int i = 0; i < 1; i++) {
            // Loop body executes once, y unchanged
            if (y > 200) { // Always false // [REPORTED LINE]
                throw new RuntimeException("Exceeded");
            }
        }
    }
}