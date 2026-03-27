// Unbraced then branch with same-line further indented successor should be flagged as positive.
package scensct.var.pos;

public class PosCase5_Var1 {
    public static void main(String[] args) {
        boolean condition = true;
        if (condition) {
            // Dummy block to show braces elsewhere, but keep target unbraced
        }
        if (condition)
            System.out.println("Then branch"); // [REPORTED LINE]
            System.out.println("Misleading successor"); // Same indentation pattern
        System.out.println("After everything");
    }
}