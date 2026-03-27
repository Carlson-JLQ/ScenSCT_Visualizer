// Double-checked locking with no side-effects besides assignment in synchronized block should not be flagged as a race condition.
package scensct.var.neg;

public class NegCase2_Var2 {
    private static final Object LOCK = new Object();
    private Object field;

    public Object getField() {
        if (field == null) {
            synchronized (LOCK) { // different lock object
                if (field == null) {
                    field = new Object();
                    // still no side-effects
                }
            }
        }
        return field;
    }
}