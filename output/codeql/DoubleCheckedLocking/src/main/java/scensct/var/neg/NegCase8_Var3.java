// A method with null check on f inside synchronized block but not as inner if condition should not be flagged as double-checked locking.
package scensct.var.neg;

public class NegCase8_Var3 {
    private Object f;

    public void method() {
        // outer null check
        if (f == null) {
            // try-finally around synchronized, but logic unchanged
            synchronized (this) {
                try {
                    boolean flag = (f == null);
                    if (flag) {
                        f = new Object();
                    }
                } finally {
                    // empty finally, just to add complexity
                }
            }
        }
    }
}