// Nested instance field self-assignment within the same class via the same qualifier chain should be flagged as a self-assignment typo.
package scensct.core.pos;

public class PosCase4 {
    static class SubHolder {
        int subfield;
    }
    private SubHolder obj = new SubHolder();

    public void method() {
        // Scenario 4: Nested instance field self-assignment within the same class, accessed via this.
        this.obj.subfield = this.obj.subfield; // Should trigger report // [REPORTED LINE]
    }
}