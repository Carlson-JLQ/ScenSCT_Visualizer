// Double-checked locking where inner if's then-block does not assign to the checked field should not be flagged as a race condition.
package scensct.var.neg;

public class NegCase3_Var4 {
    private Object field;
    private Object otherField;

    private void initOtherField() {
        otherField = new Object();
    }

    public Object getField() {
        if (field == null) {
            synchronized (this) {
                if (field == null) {
                    // Move the assignment into a helper method
                    initOtherField();
                }
            }
        }
        return field;
    }
}