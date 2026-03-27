// Double-checked locking with no side-effects besides assignment in synchronized block should not be flagged as a race condition.
package scensct.var.neg;

public class NegCase2_Var3 {
    private Object field;

    public Object getField() {
        if (field == null) {
            synchronized (this) {
                if (field == null) {
                    Object tmp = new Object();
                    field = tmp; // assignment via temporary
                }
            }
        }
        return field;
    }
}