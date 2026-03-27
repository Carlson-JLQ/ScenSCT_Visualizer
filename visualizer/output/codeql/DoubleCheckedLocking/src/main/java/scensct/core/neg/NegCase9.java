// A method implementing double-checked locking with volatile field should not be flagged as unsafe.
package scensct.core.neg;

public class NegCase9 {
    private volatile Object f; // volatile field

    public void method() {
        if (f == null) { // outer if null check on f
            synchronized (this) {
                if (f == null) { // inner if null check on f
                    f = new Object();
                }
            }
        }
    }
}