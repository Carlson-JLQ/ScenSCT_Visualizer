// Nested field self-assignment via the same qualifier chain should be flagged as a self-assignment typo.
package scensct.core.pos;

public class PosCase3 {
    static class SubHolder {
        int subfield;
    }
    static class Holder {
        SubHolder field = new SubHolder();
    }

    public void method() {
        Holder obj = new Holder();
        // Scenario 3: Nested field self-assignment with same qualifier chain.
        obj.field.subfield = obj.field.subfield; // Should trigger report // [REPORTED LINE]
    }
}