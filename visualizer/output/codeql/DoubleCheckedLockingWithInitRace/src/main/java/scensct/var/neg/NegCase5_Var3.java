// Outer if condition is inequality (false polarity) should not be flagged as a race condition.
package scensct.var.neg;

public class NegCase5_Var3 {
    private Object field;
    private final Object lock = new Object();

    public Object getField() {
        if (field != null) {
            synchronized (lock) { // change lock object
                if (field == null) {
                    field = new Object();
                }
            }
        }
        return field;
    }
}