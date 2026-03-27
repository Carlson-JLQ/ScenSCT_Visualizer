// Direct field self-assignment via the same qualifier expression should be flagged as a self-assignment typo.
package scensct.var.pos;

public class PosCase2_Var4 {
    static class Holder {
        int field;
    }

    public void method() {
        Holder obj = new Holder();
        // Use a try-finally block; assignment inside try, no effect on qualifier
        try {
            obj.field = obj.field; // [REPORTED LINE]
        } finally {
            // empty finally
        }
    }
}