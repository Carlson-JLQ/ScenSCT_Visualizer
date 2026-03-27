// Instance field self-assignment within the same class should be flagged as a self-assignment typo.
package scensct.var.pos;

public class PosCase1_Var4 {
    private int x;

    public void method() {
        // Variant 4: Loop restructuring that executes exactly once.
        for (int i = 0; i < 1; i++) {
            x = x; // Should trigger report // [REPORTED LINE]
        }
    }
}