// If condition inside loop with constant false comparison and increment compared to itself, then branch not a throw.
package scensct.var.pos;

public class PosCase4_Var3 {
    // Variant 3: extract condition to a helper method
    private static boolean alwaysFalse(int x) {
        return --x >= x; // Always false // [REPORTED LINE]
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            if (alwaysFalse(i)) {
                System.out.println("Unreachable");
            }
        }
    }
}