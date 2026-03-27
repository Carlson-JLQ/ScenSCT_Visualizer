// Inner if condition is not an equality test should not be flagged as a race condition.
package scensct.var.neg;

public class NegCase7_Var5 {
    private Object field;
    private boolean flag = true;

    public Object getField() {
        if (field != null) {
            return field;
        }
        synchronized (this) {
            if (flag) { // inner condition unchanged
                field = new Object();
            }
        }
        return field;
    }
}