// Outer if condition is not an equality test should not be flagged as a race condition.
package scensct.core.neg;

public class NegCase9 {
    private Object field;

    public Object getField() {
        if (true) { // IF1: condition is not equality test (boolean literal)
            synchronized (this) {
                if (field == null) { // IF2: inner null check
                    field = new Object();
                }
            }
        }
        return field;
    }
}