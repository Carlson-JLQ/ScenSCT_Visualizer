// Double-checked locking with assignment to another field after the field assignment should be flagged as potential race condition.
package scensct.var.pos;

public class PosCase1_Var5 {
    private Object f;
    private Object otherField;

    public Object getF() {
        if (f != null) {
            return f;
        }
        synchronized (this) {
            if (f == null) {
                f = new Object();
                otherField = new Object();
            }
            return f;
        }
    }
}