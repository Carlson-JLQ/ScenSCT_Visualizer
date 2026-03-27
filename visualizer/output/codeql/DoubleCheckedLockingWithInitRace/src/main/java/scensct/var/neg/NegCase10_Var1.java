// Synchronized block contains no inner if-statement should not be flagged as a race condition.
package scensct.var.neg;

public class NegCase10_Var1 {
    private Object field;

    public Object getField() {
        final boolean isNull = (field == null);
        if (isNull) {
            synchronized (this) {
                field = new Object();
            }
        }
        return field;
    }
}