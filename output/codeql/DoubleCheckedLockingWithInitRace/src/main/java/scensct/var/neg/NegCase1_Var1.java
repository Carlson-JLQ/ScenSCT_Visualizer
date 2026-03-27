// Double-checked locking where inner if's condition reads field via a method call should not be flagged as a race condition.
package scensct.var.neg;

public class NegCase1_Var1 {
    private Object field;

    public Object getField() {
        // Variant 1: Inverted outer condition with early return, inner check unchanged
        if (field != null) {
            return field;
        }
        synchronized (this) {
            if (getField() == null) {
                field = new Object();
            }
        }
        return field;
    }
}