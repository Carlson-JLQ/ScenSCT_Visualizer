// Direct field self-assignment via the same qualifier expression should be flagged as a self-assignment typo.
package scensct.core.pos;

public class PosCase2 {
    static class Holder {
        int field;
    }

    public void method() {
        Holder obj = new Holder();
        // Scenario 2: Direct field self-assignment with same qualifier.
        obj.field = obj.field; // Should trigger report // [REPORTED LINE]
    }
}