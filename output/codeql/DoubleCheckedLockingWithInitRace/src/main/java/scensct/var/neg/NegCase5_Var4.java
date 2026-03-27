// Outer if condition is inequality (false polarity) should not be flagged as a race condition.
package scensct.var.neg;

public class NegCase5_Var4 {
    private Object field;

    public Object getField() {
        if (field != null) {
            enterSyncAndInit();
        }
        return field;
    }

    private void enterSyncAndInit() {
        synchronized (this) {
            if (field == null) {
                field = new Object();
            }
        }
    }
}