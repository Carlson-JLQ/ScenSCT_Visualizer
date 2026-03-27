// Loop with constant condition re-evaluation but condition contains non-final field read should not be flagged.
package scensct.var.neg;

public class NegCase9_Var5 {
    private int flag = 0;
    public void test() {
        // Variant 4: Idiomatic variation - do-while loop (always runs at least once).
        do {
            // No update to flag.
        } while (flag < 10); // Condition checked after first iteration.
    }
}