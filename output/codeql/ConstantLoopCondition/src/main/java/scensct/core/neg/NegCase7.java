// Loop with constant condition re-evaluation but variable defined inside loop should not be flagged.
package scensct.core.neg;

public class NegCase7 {
    public static void main(String[] args) {
        // Loop with condition using variable defined inside loop body.
        while (true) {
            int x = 0; // Variable defined inside loop.
            if (x == 0) { // Condition uses variable defined inside loop.
                break; // Exit controlled by condition block.
            }
        }
    }
}