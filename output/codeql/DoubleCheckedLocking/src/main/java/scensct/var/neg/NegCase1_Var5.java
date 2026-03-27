// A method with outer if null check on non-volatile field and synchronized block but no inner if should not be flagged as double-checked locking.
package scensct.var.neg;

public class NegCase1_Var5 {
    private Object f;

    public void method() {
        if (f == null) {
            synchronized (this) {
                // No inner if, but assignment uses ternary (redundantly)
                f = f == null ? new Object() : f; // left side of ternary is always true here
            }
        }
    }
}