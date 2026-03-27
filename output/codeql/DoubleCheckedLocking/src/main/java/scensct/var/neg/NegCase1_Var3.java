// A method with outer if null check on non-volatile field and synchronized block but no inner if should not be flagged as double-checked locking.
package scensct.var.neg;

public class NegCase1_Var3 {
    private Object f;

    public void method() {
        if (f == null) {
            initializeField(); // helper contains the synchronized block
        }
    }

    private void initializeField() {
        synchronized (this) {
            // No inner null-check
            f = new Object();
        }
    }
}