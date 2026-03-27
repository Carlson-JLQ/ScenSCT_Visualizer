// Outer if condition reads field via method call (not direct/local/assignment) should not be flagged as a race condition.
package scensct.core.neg;

public class NegCase6 {
    private Object field;

    private Object getFieldInternal() {
        return field;
    }

    public Object getField() {
        if (null == getFieldInternal()) { // IF1: null check via method call (not direct/local/assignment read)
            synchronized (this) {
                if (field == null) { // IF2: inner null check
                    field = new Object();
                }
            }
        }
        return field;
    }
}