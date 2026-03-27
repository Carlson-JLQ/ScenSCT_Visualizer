// for loop with true condition and if with constant condition controlling all exits should be flagged as infinite loop
package scensct.var.pos;

public class PosCase4_Var3 {
    private static final int FLAG = 0;
    
    private static boolean checkFlag() {
        return FLAG > 0;
    }
    
    public static void main(String[] args) {
        // Variant 3: condition moved to static helper method
        while (true) {
            if (checkFlag()) {
                break;
            }
            System.out.println("stuck");
        }
    }
}