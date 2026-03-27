// Unbraced else branch in else chain with same-line successor and less indented controlling if should be flagged as positive.
package scensct.var.pos;

public class PosCase6_Var4 {
    public static void main(String[] args) {
        boolean condition = false;
        boolean anotherCondition = false;
        try {
            if (condition) {
                System.out.println("First if");
            } else if (anotherCondition) {
                System.out.println("Else if");
            } else
                System.out.println("Else branch"); // Unbraced else branch // [REPORTED LINE]
                System.out.println("Misleading successor"); // Same indentation pattern inside try
        } catch (Exception e) {
            // No effect
        }
    }
}