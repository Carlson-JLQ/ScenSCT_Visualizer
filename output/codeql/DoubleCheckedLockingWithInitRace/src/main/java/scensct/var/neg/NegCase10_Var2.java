// Synchronized block contains no inner if-statement should not be flagged as a race condition.
package scensct.var.neg;

public class NegCase10_Var2 {
    private Object field;

    public Object getField() {
        if (field == null) {
            synchronized (this) {
                Object temp = new Object();
                field = temp;
            }
        }
        return field;
    }
}