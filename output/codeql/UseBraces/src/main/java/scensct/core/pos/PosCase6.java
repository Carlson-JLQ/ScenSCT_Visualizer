// Unbraced else branch in else chain with same-line successor and less indented controlling if should be flagged as positive.
package scensct.core.pos;

public class PosCase6 {
    public static void main(String[] args) {
        boolean condition = false;
        boolean anotherCondition = false;
        if (condition) {
            System.out.println("First if");
        } else if (anotherCondition) {
            System.out.println("Else if");
        } else
            System.out.println("Else branch"); // Unbraced else branch, not another if // [REPORTED LINE]
            System.out.println("Misleading successor"); // Same line, indented further, controlling if less indented
    }
}