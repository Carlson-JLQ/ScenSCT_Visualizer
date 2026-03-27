// A method with outer if condition not being == null comparison should not be flagged as double-checked locking.
package scensct.core.neg;

public class NegCase2 {
    private Object f; // non-volatile field

    public void method() {
        if (f != null) { // outer if condition is NOT == null
            synchronized (this) {
                if (f == null) { // inner if with null check
                    f = new Object();
                }
            }
        }
    }
}