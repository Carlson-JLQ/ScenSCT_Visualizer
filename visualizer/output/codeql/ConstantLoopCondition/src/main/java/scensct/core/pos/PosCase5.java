// while true loop with if condition using variable defined outside controlling all exits should be flagged as infinite loop
package scensct.core.pos;

public class PosCase5 {
    public static void main(String[] args) {
        int counter = 0;
        // Loop with explicit true condition
        while (true) {
            // if condition uses variable defined outside, constant
            if (counter == 1) { // [REPORTED LINE]
                return; // Only exit controlled by constant condition
            }
            System.out.println("stuck");
        }
    }
}