// A method implementing double-checked locking on non-volatile field of immutable type should not be flagged as unsafe.
package scensct.core.neg;

public class NegCase10 {
    private String f; // non-volatile field of immutable type String

    public void method() {
        if (f == null) { // outer if null check on f - only read outside synchronized block
            synchronized (this) {
                if (f == null) { // inner if null check on f
                    f = "initialized";
                }
            }
        }
    }
}