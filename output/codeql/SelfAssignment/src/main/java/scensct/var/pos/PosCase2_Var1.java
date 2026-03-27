// Direct field self-assignment via the same qualifier expression should be flagged as a self-assignment typo.
package scensct.var.pos;

public class PosCase2_Var1 {
    static class Holder {
        int field;
    }

    public void method() {
        Holder obj = new Holder();
        // Introduce a temporary alias via a local variable
        Holder alias = obj;
        alias.field = alias.field; // [REPORTED LINE]
    }
}