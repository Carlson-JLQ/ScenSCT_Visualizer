// Nested field self-assignment via the same qualifier chain should be flagged as a self-assignment typo.
package scensct.var.pos;

public class PosCase3_Var2 {
    static class SubHolder {
        int subfield;
    }
    static class Holder {
        SubHolder field = new SubHolder();
    }

    public void method() {
        Holder obj = new Holder();
        // Refactor into a try-finally block, keeping the self-assignment inside
        try {
            obj.field.subfield = obj.field.subfield; // [REPORTED LINE]
        } finally {
            // No-op, just to add control flow complexity
            System.out.println("Completed assignment");
        }
    }
}