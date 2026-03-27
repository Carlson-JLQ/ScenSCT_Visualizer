// Synchronized block contains no inner if-statement should not be flagged as a race condition.
package scensct.var.neg;

public class NegCase10_Var6 {
    private Object field;

    public Object getField() {
        if (field == null) {
            synchronized (this) {
                try {
                    field = new Object();
                } finally {
                    // empty, just for structure
                }
            }
        }
        return field;
    }
}