// Nested instance field self-assignment within the same class via the same qualifier chain should be flagged as a self-assignment typo.
package scensct.var.pos;

public class PosCase4_Var3 {
    static class SubHolder {
        int subfield;
    }
    private SubHolder obj = new SubHolder();

    public void method() {
        // Variant 3: Split the assignment into two steps with an intermediate read.
        int val = this.obj.subfield;
        this.obj.subfield = val;
    }
}