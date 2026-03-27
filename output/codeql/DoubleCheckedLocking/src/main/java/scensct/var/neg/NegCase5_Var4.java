// A method with null check on f not being the outer if condition should not be flagged as double-checked locking.
package scensct.var.neg;

public class NegCase5_Var4 {
    private Object f; // non-volatile field

    public void method() {
        // Wrap the synchronized block in a try-finally, outer condition via a local wrapper
        Object lock = this;
        boolean needSync = (f == null);
        if (needSync) {
            synchronized (lock) {
                try {
                    if (f == null) {
                        f = new Object();
                    }
                } finally {
                    // dummy cleanup
                    int x = 0;
                }
            }
        }
    }
}