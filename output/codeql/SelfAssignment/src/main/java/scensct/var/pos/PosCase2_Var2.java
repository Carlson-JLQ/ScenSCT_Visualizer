// Direct field self-assignment via the same qualifier expression should be flagged as a self-assignment typo.
package scensct.var.pos;

public class PosCase2_Var2 {
    static class Holder {
        int field;
    }

    public void method() {
        Holder obj = new Holder();
        // Wrap in a trivial if-true block to test control-flow sensitivity
        if (true) {
            obj.field = obj.field; // [REPORTED LINE]
        }
    }
}