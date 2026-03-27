// A method with outer if condition not being == null comparison should not be flagged as double-checked locking.
package scensct.var.neg;

public class NegCase2_Var5 {
    private Object f; // non-volatile field

    public void method() {
        // Variant 5: Outer condition split across early return
        if (f == null) {
            return;
        }
        // Now f != null is implicitly true here
        synchronized (this) {
            if (f == null) {
                f = new Object();
            }
        }
    }
}