// Synchronized block contains no inner if-statement should not be flagged as a race condition.
package scensct.var.neg;

public class NegCase10_Var5 {
    private volatile Object field;

    public Object getField() {
        if (field == null) {
            synchronized (this) {
                field = new Object();
            }
        }
        return field;
    }
}