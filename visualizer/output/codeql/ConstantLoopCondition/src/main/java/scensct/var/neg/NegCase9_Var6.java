// Loop with constant condition re-evaluation but condition contains non-final field read should not be flagged.
package scensct.var.neg;

public class NegCase9_Var6 {
    private int flag = 0;
    public void test() {
        // Variant 5: Control-flow restructuring with irrelevant statements.
        if (flag >= 10) {
            return; // Early return, but loop still reachable if flag < 10.
        }
        while (true) { // Infinite loop on surface.
            if (flag >= 10) break; // Break condition reads non-final field.
            // No update to flag.
        }
    }
}