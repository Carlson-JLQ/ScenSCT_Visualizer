// Outer if condition is inequality (false polarity) should not be flagged as a race condition.
package scensct.var.neg;

public class NegCase5_Var5 {
    private Object field;

    public Object getField() {
        if (field != null) {
            synchronized (this) {
                try {
                    if (field == null) {
                        field = new Object();
                    }
                } finally {
                    // empty finally, just for structure
                }
            }
        }
        return field;
    }
}