// Double-checked locking where inner if's then-block does not assign to the checked field should not be flagged as a race condition.
package scensct.core.neg;

public class NegCase3 {
    private Object field;
    private Object otherField;

    public Object getField() {
        if (field == null) { // IF1: outer null check
            synchronized (this) {
                if (field == null) { // IF2: inner null check
                    // No assignment to field (assigns to different field)
                    otherField = new Object();
                }
            }
        }
        return field;
    }
}