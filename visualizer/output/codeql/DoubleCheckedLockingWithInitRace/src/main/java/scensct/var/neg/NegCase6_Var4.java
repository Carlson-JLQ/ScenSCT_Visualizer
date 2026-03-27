// Outer if condition reads field via method call (not direct/local/assignment) should not be flagged as a race condition.
package scensct.var.neg;

public class NegCase6_Var4 {
    private Object field;

    private Object obtainField() {
        return field;
    }

    private void initFieldIfNeeded() { // extract sync block to helper
        synchronized (this) {
            if (field == null) {
                field = new Object();
            }
        }
    }

    public Object getField() {
        if (obtainField() == null) {
            initFieldIfNeeded();
        }
        return field;
    }
}