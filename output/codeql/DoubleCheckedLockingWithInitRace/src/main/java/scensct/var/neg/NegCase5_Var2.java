// Outer if condition is inequality (false polarity) should not be flagged as a race condition.
package scensct.var.neg;

public class NegCase5_Var2 {
    private Object field;

    public Object getField() {
        Object local = field; // introduce local alias
        if (local != null) {
            synchronized (this) {
                if (field == null) {
                    field = new Object();
                }
            }
        }
        return field;
    }
}