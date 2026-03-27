// Inner if condition is not an equality test should not be flagged as a race condition.
package scensct.var.neg;

public class NegCase7_Var4 {
    private Object field;
    private volatile boolean allowCreation = true;

    public Object getField() {
        if (field == null) {
            synchronized (this) {
                if (allowCreation) { // volatile boolean, still not equality on 'field'
                    field = new Object();
                }
            }
        }
        return field;
    }
}