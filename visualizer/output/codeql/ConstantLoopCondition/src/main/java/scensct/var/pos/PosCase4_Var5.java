// for loop with true condition and if with constant condition controlling all exits should be flagged as infinite loop
package scensct.var.pos;

public class PosCase4_Var5 {
    public static void main(String[] args) {
        int flag = 0;
        // Variant 5: do-while with constant true, condition negated via temporary
        boolean notExiting = flag <= 0;
        do {
            if (!notExiting) { // [REPORTED LINE]
                break;
            }
            System.out.println("stuck");
        } while (true);
    }
}