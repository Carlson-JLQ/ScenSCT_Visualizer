// A method with outer if null check on non-volatile field and synchronized block but no inner if should not be flagged as double-checked locking.
package scensct.core.neg;

public class NegCase1 {
    private Object f; // non-volatile field

    public void method() {
        if (f == null) { // outer if with null check on f
            synchronized (this) {
                // No inner if statement inside synchronized block
                f = new Object();
            }
        }
    }
}