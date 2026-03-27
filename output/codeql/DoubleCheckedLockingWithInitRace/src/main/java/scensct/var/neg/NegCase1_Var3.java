// Double-checked locking where inner if's condition reads field via a method call should not be flagged as a race condition.
package scensct.var.neg;

public class NegCase1_Var3 {
    private Object field;

    public Object getField() {
        // Variant 3: Restructure with while loop and break (still double-checked)
        while (field == null) {
            synchronized (this) {
                if (getField() == null) {
                    field = new Object();
                }
                break;
            }
        }
        return field;
    }
}