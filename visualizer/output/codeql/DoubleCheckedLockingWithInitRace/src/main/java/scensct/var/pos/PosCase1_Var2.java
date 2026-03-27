// Double-checked locking with assignment to another field after the field assignment should be flagged as potential race condition.
package scensct.var.pos;

public class PosCase1_Var2 {
    private Object f;
    private Object otherField;

    public Object getF() {
        if (f == null) {
            synchronized (this) {
                if (f == null) {
                    Object tmp = new Object();
                    f = tmp; // [REPORTED LINE]
                    otherField = new Object();
                }
            }
        }
        return f;
    }
}