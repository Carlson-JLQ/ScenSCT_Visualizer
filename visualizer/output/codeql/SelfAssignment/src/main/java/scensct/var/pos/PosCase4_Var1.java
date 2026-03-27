// Nested instance field self-assignment within the same class via the same qualifier chain should be flagged as a self-assignment typo.
package scensct.var.pos;

public class PosCase4_Var1 {
    static class SubHolder {
        int subfield;
    }
    private SubHolder obj = new SubHolder();

    public void method() {
        // Variant 1: Introduce a temporary variable for the qualifier chain.
        SubHolder temp = this.obj;
        temp.subfield = temp.subfield; // [REPORTED LINE]
    }
}