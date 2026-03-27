// for loop with true condition and if with constant condition controlling all exits should be flagged as infinite loop
package scensct.var.pos;

public class PosCase4_Var2 {
    public static void main(String[] args) {
        final int immutableFlag = 0;
        // Variant 2: for loop with condition as final variable, added dead increment
        for (int i = 0; ; i++) {
            if (immutableFlag > 0) { // [REPORTED LINE]
                break;
            }
            System.out.println("stuck");
            // Dead continue, does not affect control flow
            continue;
        }
    }
}