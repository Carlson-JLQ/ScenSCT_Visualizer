// Nested field self-assignment via the same qualifier chain should be flagged as a self-assignment typo.
package scensct.var.pos;

public class PosCase3_Var5 {
    static class SubHolder {
        int subfield;
    }
    static class Holder {
        SubHolder field = new SubHolder();
    }

    public void method() {
        Holder obj = new Holder();
        // Introduce an alias via a cast (no-op) to the same type
        SubHolder alias = (SubHolder) obj.field;
        alias.subfield = alias.subfield; // [REPORTED LINE]
    }
}