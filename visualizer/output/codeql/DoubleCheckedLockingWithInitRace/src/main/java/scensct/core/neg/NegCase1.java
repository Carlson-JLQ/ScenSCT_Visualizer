// Double-checked locking where inner if's condition reads field via a method call should not be flagged as a race condition.
package scensct.core.neg;

public class NegCase1 {
    private Object field;

    public Object getField() {
        if (field == null) { // IF1: outer null check (true polarity, direct)
            synchronized (this) {
                if (getField() == null) { // IF2: inner null check via method call (not direct/local/assignment read)
                    field = new Object();
                }
            }
        }
        return field;
    }
}