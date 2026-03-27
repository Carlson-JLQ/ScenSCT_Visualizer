// Equality test inside loop after controlling equality, with increment compared to itself, if condition then branch not a throw.
package scensct.var.pos;

public class PosCase8_Var4 {
    // Extract the core equality test into a helper method
    private static boolean alwaysFalseTest(int val) {
        // The method receives the value before increment
        return val == val + 1; // Always false // [REPORTED LINE]
    }

    public static void main(String[] args) {
        int x = 0;
        while (x < 5) {
            if (x == 2) {
                // Call helper with x, then increment x separately
                if (alwaysFalseTest(x++)) {
                    System.out.println("Unreachable");
                }
            }
            x++;
        }
    }
}