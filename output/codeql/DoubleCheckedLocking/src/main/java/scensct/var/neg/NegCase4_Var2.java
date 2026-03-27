// A method with outer if null check on a different field should not be flagged as double-checked locking on field f.
package scensct.var.neg;

public class NegCase4_Var2 {
    private Object f;
    private Object g;

    private boolean shouldSkip() {
        return g != null;
    }

    public void method() {
        if (shouldSkip()) {
            return;
        }
        Object lock = this;
        synchronized (lock) {
            if (f == null) {
                f = new Object();
            }
        }
    }
}