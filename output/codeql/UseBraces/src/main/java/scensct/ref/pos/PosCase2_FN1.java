// Unbraced loop in else chain with misleading same-line further indented successor should be flagged as positive.
package scensct.ref.pos;

public class PosCase2_FN1 {
    public static void main(String[] args) {
        boolean condition = false;
        boolean loopCondition = true;
        if (condition) {
            System.out.println("If branch");
        } else while (loopCondition)
            System.out.println("Loop body"); // Unbraced loop body in else chain
            System.out.println("Misleading successor"); // Same line, indented further than loop body
    }
}