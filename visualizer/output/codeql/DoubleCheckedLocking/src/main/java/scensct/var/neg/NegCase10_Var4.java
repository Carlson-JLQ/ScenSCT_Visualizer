// A method implementing double-checked locking on non-volatile field of immutable type should not be flagged as unsafe.
package scensct.var.neg;

public class NegCase10_Var4 {
    private String f;

    public void method() {
        if (f == null) {
            // wrap synchronization in try-finally (no-op finally)
            synchronized (this) {
                try {
                    if (f == null) {
                        f = "init";
                    }
                } finally {
                    // benign cleanup-like comment
                }
            }
        }
    }
}