// Direct field self-assignment via the same qualifier expression should be flagged as a self-assignment typo.
package scensct.var.pos;

public class PosCase2_Var5 {
    static class Holder {
        int field;
    }

    public void method() {
        Holder obj = new Holder();
        // Add a redundant cast (no runtime effect) to challenge expression parsing
        ((Holder) obj).field = ((Holder) obj).field;
    }
}