// Double-checked locking where inner if's condition reads field via a method call should not be flagged as a race condition.
package scensct.var.neg;

public class NegCase1_Var4 {
    private Object field;

    // Helper method for inner null check
    private boolean isFieldNull() {
        return getField() == null;
    }

    public Object getField() {
        // Variant 4: Inner check via helper method (still indirect read)
        if (field == null) {
            synchronized (this) {
                if (isFieldNull()) {
                    field = new Object();
                }
            }
        }
        return field;
    }
}