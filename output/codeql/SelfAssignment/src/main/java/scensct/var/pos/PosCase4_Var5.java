// Nested instance field self-assignment within the same class via the same qualifier chain should be flagged as a self-assignment typo.
package scensct.var.pos;

public class PosCase4_Var5 {
    static class SubHolder {
        int subfield;
    }
    private SubHolder obj = new SubHolder();

    public void method() {
        // Variant 5: Wrap the assignment in a try-catch block (catch does nothing).
        try {
            this.obj.subfield = this.obj.subfield; // [REPORTED LINE]
        } catch (Exception e) {
            // Ignore
        }
    }
}