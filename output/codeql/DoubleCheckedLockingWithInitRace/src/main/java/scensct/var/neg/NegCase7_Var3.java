// Inner if condition is not an equality test should not be flagged as a race condition.
package scensct.var.neg;

public class NegCase7_Var3 {
    private Object field;
    private boolean initialized = false;

    public Object getField() {
        if (field == null) {
            computeFieldIfNeeded();
        }
        return field;
    }

    private void computeFieldIfNeeded() {
        synchronized (this) {
            if (!initialized) { // not equality on 'field'
                field = new Object();
                initialized = true;
            }
        }
    }
}