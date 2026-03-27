// Equality test inside loop after controlling equality, with increment compared to itself, if condition then branch not a throw.
package scensct.var.pos;

public class PosCase8_Var5 {
    public static void main(String[] args) {
        int x = 0;
        // Unroll the loop partially to expose the pattern in multiple iterations
        while (x < 5) {
            switch (x) {
                case 2:
                    // Use a different binary operator but same semantics: x++ != x is always true, but we keep equality
                    boolean result = (x++ == x); // [REPORTED LINE]
                    if (result) {
                        System.out.println("Unreachable");
                    }
                    break;
                default:
                    // Do nothing special
                    break;
            }
            x++;
        }
    }
}