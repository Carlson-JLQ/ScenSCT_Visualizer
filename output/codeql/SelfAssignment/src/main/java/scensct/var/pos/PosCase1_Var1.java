// Instance field self-assignment within the same class should be flagged as a self-assignment typo.
package scensct.var.pos;

public class PosCase1_Var1 {
    private int x;

    public void method() {
        // Variant 1: Lexical refactoring with explicit 'this' and temporary variable.
        int temp = this.x;
        this.x = temp; // Should trigger report
    }
}