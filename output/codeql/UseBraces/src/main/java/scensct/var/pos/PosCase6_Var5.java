// Unbraced else branch in else chain with same-line successor and less indented controlling if should be flagged as positive.
package scensct.var.pos;

public class PosCase6_Var5 {
    public static void main(String[] args) {
        boolean x = false;
        boolean y = false;
        boolean condition = x;
        boolean anotherCondition = y;
        if (condition) {
            printFirst();
        } else if (anotherCondition) {
            printElseIf();
        } else
            printElse(); // Unbraced else branch // [REPORTED LINE]
            printMisleading(); // Same line, indented further
    }

    private static void printFirst() { System.out.println("First if"); }
    private static void printElseIf() { System.out.println("Else if"); }
    private static void printElse() { System.out.println("Else branch"); }
    private static void printMisleading() { System.out.println("Misleading successor"); }
}