// Equality test inside loop after controlling equality, with increment compared to itself, if condition then branch not a throw.
package scensct.core.pos;

public class PosCase8 {
    public static void main(String[] args) {
        int x = 0;
        while (x < 5) {
            if (x == 2) {
                // Inside block controlled by x==2, the equality test with increment is always false
                // Scenario 8: x++ == x is always false (x++ returns old value, then x is incremented)
                if (x++ == x) { // Always false // [REPORTED LINE]
                    // Then branch not a single throw
                    System.out.println("Unreachable");
                }
            }
            x++;
        }
    }
}