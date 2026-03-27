// Nested field self-assignment via the same qualifier chain should be flagged as a self-assignment typo.
package scensct.var.pos;

public class PosCase3_Var4 {
    static class SubHolder {
        int subfield;
    }
    static class Holder {
        SubHolder field = new SubHolder();
    }

    public void method() {
        Holder obj = new Holder();
        // Use a conditional that always takes the true branch, but structurally obfuscates
        if (true) {
            obj.field.subfield = obj.field.subfield; // [REPORTED LINE]
        } else {
            // Dead code, never reached
            obj.field.subfield = 42;
        }
    }
}