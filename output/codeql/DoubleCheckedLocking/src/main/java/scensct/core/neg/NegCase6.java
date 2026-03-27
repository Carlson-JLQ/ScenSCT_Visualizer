// A method with inner if condition not being == null check should not be flagged as double-checked locking.
package scensct.core.neg;

public class NegCase6 {
    private Object f; // non-volatile field

    public void method() {
        if (f == null) { // outer if null check on f
            synchronized (this) {
                Object local = new Object();
                if (f == local) { // inner if condition is not null check
                    f = new Object();
                }
            }
        }
    }
}