// Unbraced loop in else chain with misleading same-line further indented successor should be flagged as positive.
package scensct.core.pos;

public class PosCase2 {
    public static void main(String[] args) {
        boolean condition = false;
        boolean loopCondition = true;
        if (condition) {
            System.out.println("If branch");
        } else while (loopCondition)
            System.out.println("Loop body"); // Unbraced loop body in else chain
System.out.println("Misleading successor"); // Same column as while keyword, indented further than loop body
    }
}