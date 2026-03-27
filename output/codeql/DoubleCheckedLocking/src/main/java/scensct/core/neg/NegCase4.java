// A method with outer if null check on a different field should not be flagged as double-checked locking on field f.
package scensct.core.neg;

public class NegCase4 {
    private Object f; // non-volatile field
    private Object g; // another field

    public void method() {
        if (g == null) { // outer if null check on different field g
            synchronized (this) {
                if (f == null) { // inner if null check on f
                    f = new Object();
                }
            }
        }
    }
}