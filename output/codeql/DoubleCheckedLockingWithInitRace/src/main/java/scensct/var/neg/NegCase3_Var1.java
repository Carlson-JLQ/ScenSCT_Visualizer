// Double-checked locking where inner if's then-block does not assign to the checked field should not be flagged as a race condition.
package scensct.var.neg;

public class NegCase3_Var1 {
    private Object field;
    private Object otherField;

    public Object getField() {
        Object local = field;
        if (local == null) {
            synchronized (this) {
                local = field;
                if (local == null) {
                    // Still no assignment to field
                    otherField = new Object();
                }
            }
        }
        return field;
    }
}