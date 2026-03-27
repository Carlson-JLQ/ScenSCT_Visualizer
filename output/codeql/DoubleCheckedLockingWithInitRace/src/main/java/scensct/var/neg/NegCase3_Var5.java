// Double-checked locking where inner if's then-block does not assign to the checked field should not be flagged as a race condition.
package scensct.var.neg;

public class NegCase3_Var5 {
    private Object field;
    private Object otherField;

    public Object getField() {
        if (field == null) {
            Object lock = this;
            synchronized (lock) {
                if (field == null) {
                    // Use try-finally for no reason (still safe)
                    try {
                        otherField = new Object();
                    } finally {
                        // No assignment to field
                    }
                }
            }
        }
        return field;
    }
}