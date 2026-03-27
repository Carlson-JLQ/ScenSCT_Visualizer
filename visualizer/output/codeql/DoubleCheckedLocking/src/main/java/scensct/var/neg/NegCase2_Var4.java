// A method with outer if condition not being == null comparison should not be flagged as double-checked locking.
package scensct.var.neg;

public class NegCase2_Var4 {
    private Object f; // non-volatile field

    public void method() {
        // Variant 4: Outer condition with explicit else branch (no-op) and try-finally
        if (f != null) {
            try {
                synchronized (this) {
                    if (f == null) {
                        f = new Object();
                    }
                }
            } finally {
                // dummy cleanup
                int x = 0;
            }
        } else {
            // do nothing, just to show alternative path
        }
    }
}