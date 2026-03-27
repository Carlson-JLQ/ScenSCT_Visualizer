// Equality test inside loop after controlling equality, with increment compared to itself, if condition then branch not a throw.
package scensct.var.pos;

public class PosCase8_Var2 {
    public static void main(String[] args) {
        // Convert while loop to for loop, restructure increment placement
        for (int x = 0; x < 5; ) {
            if (x == 2) {
                // Move the post-increment into the condition but keep the same semantics
                int pre = x;
                if (pre == ++x) { // Now x is incremented before comparison, making it always false // [REPORTED LINE]
                    System.out.println("Unreachable");
                }
                // Adjust to avoid double increment
                continue;
            }
            x++;
        }
    }
}