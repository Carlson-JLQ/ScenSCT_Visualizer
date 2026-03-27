// while true loop with if condition using variable defined outside controlling all exits should be flagged as infinite loop
package scensct.var.pos;

public class PosCase5_Var1 {
    public static void main(String[] args) {
        int start = 0;
        // Loop with for (;;) equivalent to while (true)
        for (;;) {
            // Condition uses variable defined outside, never changed
            if (start == 1) { // [REPORTED LINE]
                break; // Only exit, but condition is constant
            }
            System.out.println("stuck");
        }
    }
}