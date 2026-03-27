// A method with outer if null check on non-volatile field and synchronized block but no inner if should not be flagged as double-checked locking.
package scensct.var.neg;

public class NegCase1_Var4 {
    private Object f;

    public void method() {
        while (f == null) { // outer check as loop condition
            synchronized (this) {
                // Still no inner null-check
                f = new Object();
                break; // exit after one iteration
            }
        }
    }
}