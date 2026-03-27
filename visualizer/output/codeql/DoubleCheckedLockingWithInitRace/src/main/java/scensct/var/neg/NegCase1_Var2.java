// Double-checked locking where inner if's condition reads field via a method call should not be flagged as a race condition.
package scensct.var.neg;

public class NegCase1_Var2 {
    private Object field;

    public Object getField() {
        // Variant 2: Introduce a temporary variable for outer check, inner via method
        Object local = field;
        if (local == null) {
            synchronized (this) {
                if (getField() == null) {
                    field = new Object();
                }
            }
        }
        return field;
    }
}