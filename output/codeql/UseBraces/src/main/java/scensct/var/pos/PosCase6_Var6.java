// Unbraced else branch in else chain with same-line successor and less indented controlling if should be flagged as positive.
package scensct.var.pos;

public class PosCase6_Var6 {
    public static void main(String[] args) {
        boolean condition = false;
        boolean anotherCondition = false;
        // Use temporary to hold condition
        boolean firstCase = condition;
        boolean secondCase = anotherCondition && !firstCase;
        if (firstCase) {
            System.out.println("First if");
        } else if (secondCase) {
            System.out.println("Else if");
        } else
            System.out.println("Else branch"); // Unbraced else branch // [REPORTED LINE]
            System.out.println("Misleading successor"); // Same indentation
    }
}