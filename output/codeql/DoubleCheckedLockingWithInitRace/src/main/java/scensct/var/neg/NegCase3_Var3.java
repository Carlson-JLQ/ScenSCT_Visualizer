// Double-checked locking where inner if's then-block does not assign to the checked field should not be flagged as a race condition.
package scensct.var.neg;

public class NegCase3_Var3 {
    private Object field;
    private Object otherField;

    public Object getField() {
        if (field == null) {
            synchronized (this) {
                boolean needsInit = field == null;
                if (needsInit) {
                    // Assignment to other field only
                    otherField = new Object();
                }
            }
        }
        return field;
    }
}