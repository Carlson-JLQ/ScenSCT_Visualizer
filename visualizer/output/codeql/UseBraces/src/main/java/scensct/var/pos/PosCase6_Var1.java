// Unbraced else branch in else chain with same-line successor and less indented controlling if should be flagged as positive.
package scensct.var.pos;

public class PosCase6_Var1 {
    public static void main(String[] args) {
        boolean flag = false;
        boolean otherFlag = false;
        if (flag) {
            System.out.println("First if");
        } else if (otherFlag) {
            System.out.println("Else if");
        } else
            System.out.println("Else branch"); // Unbraced else branch, not another if // [REPORTED LINE]
            System.err.println("Misleading successor"); // Changed to System.err, same indentation pattern
    }
}