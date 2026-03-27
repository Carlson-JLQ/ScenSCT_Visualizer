// Outer if condition is inequality (false polarity) should not be flagged as a race condition.
package scensct.core.neg;

public class NegCase5 {
    private Object field;

    public Object getField() {
        if (field != null) { // IF1: inequality check (false polarity)
            synchronized (this) {
                if (field == null) { // IF2: inner null check
                    field = new Object();
                }
            }
        }
        return field;
    }
}