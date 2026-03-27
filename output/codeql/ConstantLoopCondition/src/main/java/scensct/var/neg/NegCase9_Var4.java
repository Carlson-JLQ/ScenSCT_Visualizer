// Loop with constant condition re-evaluation but condition contains non-final field read should not be flagged.
package scensct.var.neg;

public class NegCase9_Var4 {
    private int flag = 0;
    public void test() {
        // Variant 3: Inter-procedural - condition evaluation via helper.
        while (shouldContinue()) {
            // No update to flag.
        }
    }
    private boolean shouldContinue() {
        return flag < 10; // Reads non-final field.
    }
}