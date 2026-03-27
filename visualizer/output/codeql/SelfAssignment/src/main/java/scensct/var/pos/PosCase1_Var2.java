// Instance field self-assignment within the same class should be flagged as a self-assignment typo.
package scensct.var.pos;

public class PosCase1_Var2 {
    private int x;

    public void method() {
        // Variant 2: Control-flow restructuring with a conditional that always executes.
        if (true) {
            x = x; // Should trigger report // [REPORTED LINE]
        }
    }
}