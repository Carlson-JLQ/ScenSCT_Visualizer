// Inner if condition is not an equality test should not be flagged as a race condition.
package scensct.var.neg;

public class NegCase7_Var2 {
    private Object field;
    private boolean ready = true;

    public Object getField() {
        Object local = field;
        if (local == null) {
            synchronized (this) {
                local = field;
                if (local == null && ready) { // outer equality + boolean flag
                    field = new Object();
                }
            }
        }
        return field;
    }
}