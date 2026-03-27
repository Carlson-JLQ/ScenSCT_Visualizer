// for loop with true condition and if with constant condition controlling all exits should be flagged as infinite loop
package scensct.var.pos;

public class PosCase4_Var1 {
    public static void main(String[] args) {
        int counter = 0;
        // Variant 1: while loop with explicit true, condition extracted to local boolean
        boolean shouldExit = counter > 0;
        while (true) {
            if (shouldExit) { // [REPORTED LINE]
                break;
            }
            System.out.println("stuck");
        }
    }
}