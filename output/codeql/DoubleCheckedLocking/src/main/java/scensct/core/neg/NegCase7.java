// A method with inner if null check on a different field should not be flagged as double-checked locking on field f.
package scensct.core.neg;

public class NegCase7 {
    private Object f; // non-volatile field
    private Object g; // another field

    public void method() {
        if (f == null) { // outer if null check on f
            synchronized (this) {
                if (g == null) { // inner if null check on different field g
                    f = new Object();
                }
            }
        }
    }
}