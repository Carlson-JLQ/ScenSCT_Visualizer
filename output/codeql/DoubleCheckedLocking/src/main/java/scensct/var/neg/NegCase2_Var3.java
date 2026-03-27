// A method with outer if condition not being == null comparison should not be flagged as double-checked locking.
package scensct.var.neg;

public class NegCase2_Var3 {
    private Object f; // non-volatile field

    private boolean isInitialized() {
        return f != null;
    }

    public void method() {
        // Variant 3: Outer condition moved to a helper method
        if (isInitialized()) {
            synchronized (this) {
                if (f == null) {
                    f = new Object();
                }
            }
        }
    }
}