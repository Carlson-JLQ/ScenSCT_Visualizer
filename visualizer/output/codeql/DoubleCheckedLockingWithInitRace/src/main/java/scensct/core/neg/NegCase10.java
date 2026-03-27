// Synchronized block contains no inner if-statement should not be flagged as a race condition.
package scensct.core.neg;

public class NegCase10 {
    private Object field;

    public Object getField() {
        if (field == null) { // IF1: outer null check
            synchronized (this) {
                // No inner if-statement (IF2)
                field = new Object();
            }
        }
        return field;
    }
}