// If condition inside loop with constant false comparison and increment compared to itself, then branch not a throw.
package scensct.core.pos;

public class PosCase4 {
    public static void main(String[] args) {
        int i = 0;
        while (i < 10) { // [REPORTED LINE]
            // Scenario 4: --i >= i is always false (since --i = i-1)
            if (--i >= i) { // Always false // [REPORTED LINE]
                // Then branch is not a single throw statement
                System.out.println("Unreachable");
            }
            i++;
        }
    }
}