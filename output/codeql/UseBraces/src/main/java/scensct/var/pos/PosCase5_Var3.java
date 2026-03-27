// Unbraced then branch with same-line further indented successor should be flagged as positive.
package scensct.var.pos;

public class PosCase5_Var3 {
    public static void main(String[] args) {
        boolean condition = true;
        try {
            if (condition)
                System.out.println("Then branch"); // [REPORTED LINE]
                System.out.println("Misleading successor"); // Still misleading indentation
        } finally {
            // Cleanup that doesn't affect the pattern
        }
    }
}