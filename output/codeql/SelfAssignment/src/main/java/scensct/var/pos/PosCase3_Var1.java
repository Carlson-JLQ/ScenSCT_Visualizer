// Nested field self-assignment via the same qualifier chain should be flagged as a self-assignment typo.
package scensct.var.pos;

public class PosCase3_Var1 {
    static class SubHolder {
        int subfield;
    }
    static class Holder {
        SubHolder field = new SubHolder();
    }

    public void method() {
        Holder obj = new Holder();
        // Introduce a temporary variable that still resolves to the same qualifier chain
        SubHolder temp = obj.field;
        temp.subfield = temp.subfield; // [REPORTED LINE]
    }
}