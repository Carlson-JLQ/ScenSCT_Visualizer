// Double-checked locking on non-volatile, non-immutable field should be flagged as thread-unsafe.
package scensct.var.pos;

public class PosCase1_Var4 {
    private Object instance;

    public Object getInstance() {
        // try-finally around synchronized (no functional change)
        synchronized (this) {
            try {
                if (instance == null) {
                    instance = new Object();
                }
            } finally {
                // empty finally, just to add complexity
            }
        }
        // but wait: this removed the outer check! That changes the pattern.
        // Let's correct: we must keep double-check.
        // Revised variant:
        if (instance == null) {
            synchronized (this) { // [REPORTED LINE]
                try {
                    if (instance == null) {
                        instance = new Object();
                    }
                } finally {
                    // no-op
                }
            }
        }
        return instance;
    }
}