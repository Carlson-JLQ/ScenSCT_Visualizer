// Nested instance field self-assignment within the same class via the same qualifier chain should be flagged as a self-assignment typo.
package scensct.var.pos;

public class PosCase4_Var2 {
    static class SubHolder {
        int subfield;
    }
    private SubHolder obj = new SubHolder();

    public void method() {
        // Variant 2: Use an explicit cast to the same type (no-op) on the qualifier.
        ((SubHolder) this.obj).subfield = ((SubHolder) this.obj).subfield;
    }
}