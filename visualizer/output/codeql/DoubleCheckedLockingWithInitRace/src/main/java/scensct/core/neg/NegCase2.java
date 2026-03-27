// Double-checked locking with no side-effects besides assignment in synchronized block should not be flagged as a race condition.
package scensct.core.neg;

public class NegCase2 {
    private Object field;

    public Object getField() {
        if (field == null) { // IF1: outer null check
            synchronized (this) {
                if (field == null) { // IF2: inner null check
                    field = new Object();
                    // No side-effect expressions (no non-println method calls, no other field assignments)
                }
            }
        }
        return field;
    }
}