// Nested field self-assignment via the same qualifier chain should be flagged as a self-assignment typo.
package scensct.var.pos;

public class PosCase3_Var3 {
    static class SubHolder {
        int subfield;
    }
    static class Holder {
        SubHolder field = new SubHolder();
    }

    // Extract qualifier chain into a helper method that returns the same reference
    private SubHolder getSubHolder(Holder h) {
        return h.field;
    }

    public void method() {
        Holder obj = new Holder();
        // Self-assignment via a method call that returns the same nested field
        getSubHolder(obj).subfield = getSubHolder(obj).subfield;
    }
}