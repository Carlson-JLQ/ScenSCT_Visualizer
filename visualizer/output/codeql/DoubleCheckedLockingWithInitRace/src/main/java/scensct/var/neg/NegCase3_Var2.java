// Double-checked locking where inner if's then-block does not assign to the checked field should not be flagged as a race condition.
package scensct.var.neg;

public class NegCase3_Var2 {
    private Object field;
    private Object otherField;

    public Object getField() {
        if (field == null) {
            synchronized (this) {
                if (field == null) {
                    // Introduce a temporary and a side effect, but still no field assignment
                    Object tmp = new Object();
                    otherField = tmp;
                }
            }
        }
        return field;
    }
}