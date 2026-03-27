// Unbraced else branch in else chain with same-line successor and less indented controlling if should be flagged as positive.
package scensct.var.pos;

public class PosCase6_Var2 {
    public static void main(String[] args) {
        boolean a = false;
        boolean b = false;
        boolean condition = a;
        boolean anotherCondition = b;
        if (condition == true) { // Explicit equality
            log("First if");
        } else if (anotherCondition != false) { // Negated false
            log("Else if");
        } else
            log("Else branch"); // Unbraced else branch // [REPORTED LINE]
            log("Misleading successor"); // Same line, indented further
    }

    private static void log(String msg) {
        System.out.println(msg);
    }
}