// Direct field self-assignment via the same qualifier expression should be flagged as a self-assignment typo.
package scensct.var.pos;

public class PosCase2_Var3 {
    static class Holder {
        int field;
    }

    // Extract assignment into a private helper method
    private void assignSelf(Holder target) {
        target.field = target.field; // [REPORTED LINE]
    }

    public void method() {
        Holder obj = new Holder();
        assignSelf(obj);
    }
}