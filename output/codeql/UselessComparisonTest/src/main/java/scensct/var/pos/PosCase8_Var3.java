// Equality test inside loop after controlling equality, with increment compared to itself, if condition then branch not a throw.
package scensct.var.pos;

public class PosCase8_Var3 {
    public static void main(String[] args) {
        int x = 0;
        // Use do-while loop to change loop entry condition
        do {
            if (x == 2) {
                // Wrap the condition in a try-catch to add control flow complexity
                try {
                    if (x++ == x) { // [REPORTED LINE]
                        System.out.println("Unreachable");
                    }
                } catch (Exception e) {
                    // Never thrown
                }
            }
            x++;
        } while (x < 5);
    }
}