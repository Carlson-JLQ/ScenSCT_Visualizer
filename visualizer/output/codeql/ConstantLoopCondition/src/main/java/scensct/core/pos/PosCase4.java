// for loop with true condition and if with constant condition controlling all exits should be flagged as infinite loop
package scensct.core.pos;

public class PosCase4 {
    public static void main(String[] args) {
        int flag = 0;
        // Loop with explicit true condition
        for (;;) {
            // if condition uses variable defined outside loop, constant
            if (flag > 0) { // [REPORTED LINE]
                break; // Only exit controlled by constant condition
            }
            System.out.println("stuck");
        }
    }
}