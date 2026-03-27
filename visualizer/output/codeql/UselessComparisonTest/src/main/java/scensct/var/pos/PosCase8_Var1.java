// Equality test inside loop after controlling equality, with increment compared to itself, if condition then branch not a throw.
package scensct.var.pos;

public class PosCase8_Var1 {
    public static void main(String[] args) {
        int x = 0;
        while (x < 5) {
            if (x == 2) {
                // Introduce a temporary variable to alias x, but still use x++ in comparison
                int alias = x;
                if (x++ == alias + 1) { // Equivalent to x++ == x (since alias holds old x) // [REPORTED LINE]
                    System.out.println("Unreachable");
                }
            }
            x++;
        }
    }
}