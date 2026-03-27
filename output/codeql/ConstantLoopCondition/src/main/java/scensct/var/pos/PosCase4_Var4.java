// for loop with true condition and if with constant condition controlling all exits should be flagged as infinite loop
package scensct.var.pos;

public class PosCase4_Var4 {
    public static void main(String[] args) {
        int flag = 0;
        // Variant 4: loop with try-finally, break inside try, finally does not interrupt exit
        for (;;) {
            try {
                if (flag > 0) { // [REPORTED LINE]
                    break;
                }
            } finally {
                // Cleanup that runs but doesn't prevent break
                System.out.print("");
            }
            System.out.println("stuck");
        }
    }
}