// Loop with constant condition re-evaluation but condition contains non-final field read should not be flagged.
package scensct.var.neg;

public class NegCase9_Var2 {
    private int flag = 0;
    public void test() {
        // Variant 2: Intra-procedural refactoring - for loop with temporary variable.
        for (int i = flag; i < 10; ) { // Condition uses local copy of field.
            // Loop body does nothing, i never updated.
            break; // Actually, break would exit immediately, breaking scenario.
            // Let's restructure: use while but with alias.
        }
    }
}