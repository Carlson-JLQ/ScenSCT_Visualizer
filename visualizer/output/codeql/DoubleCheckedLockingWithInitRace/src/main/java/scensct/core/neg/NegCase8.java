// Outer if condition compares field with non-null value should not be flagged as a race condition.
package scensct.core.neg;

public class NegCase8 {
    private Object field;
    private final Object otherField = new Object();

    public Object getField() {
        if (field == otherField) { // IF1: equality test not comparing with null
            synchronized (this) {
                if (field == null) { // IF2: inner null check
                    field = new Object();
                }
            }
        }
        return field;
    }
}