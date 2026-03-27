// Instance field self-assignment within the same class should be flagged as a self-assignment typo.
package scensct.var.pos;

public class PosCase1_Var3 {
    private int x;

    public void method() {
        // Variant 3: Inter-procedural refactoring: extract assignment to a private helper.
        assignSelf();
    }

    private void assignSelf() {
        x = x; // Should trigger report // [REPORTED LINE]
    }
}