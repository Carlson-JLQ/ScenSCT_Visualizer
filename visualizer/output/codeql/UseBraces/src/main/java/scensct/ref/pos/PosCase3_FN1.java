// Unbraced loop in else chain with same-column successor and less indented controlling if should be flagged as positive.
package scensct.ref.pos;

public class PosCase3_FN1 {
    public static void main(String[] args) {
        boolean condition = false;
        boolean loopCondition = true;
        if (condition) {
            System.out.println("If branch");
        } else while (loopCondition)
            System.out.println("Loop body"); // Unbraced loop body in else chain
        System.out.println("Misleading successor"); // Same column as body, controlling if less indented
    }
}