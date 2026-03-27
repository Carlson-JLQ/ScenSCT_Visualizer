// Unbraced then branch with same-line further indented successor should be flagged as positive.
package scensct.var.pos;

public class PosCase5_Var4 {
    public static void main(String[] args) {
        boolean condition = true;
        if (condition) return; // Early return, but the pattern is still present
        if (!condition) {
            // Do nothing
        } else if (condition) // This else-if is a distraction
            System.out.println("Then branch"); // [REPORTED LINE]
            System.out.println("Misleading successor"); // Same line, indented further
    }
}