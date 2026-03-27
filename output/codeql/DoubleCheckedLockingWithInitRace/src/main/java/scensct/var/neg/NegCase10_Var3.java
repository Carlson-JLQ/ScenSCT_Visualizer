// Synchronized block contains no inner if-statement should not be flagged as a race condition.
package scensct.var.neg;

public class NegCase10_Var3 {
    private Object field;

    public Object getField() {
        if (field == null) {
            initializeField();
        }
        return field;
    }

    private void initializeField() {
        synchronized (this) {
            field = new Object();
        }
    }
}