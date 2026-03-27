// A method with inner if condition not being == null check should not be flagged as double-checked locking.
package scensct.var.neg;

public class NegCase6_Var5 {
    private Object f;

    public void method() {
        if (f == null) {
            synchronized (this) {
                try {
                    Object local = new Object();
                    if (f == local) {
                        f = new Object();
                    }
                } finally {
                    // empty finally, just to add control-flow complexity
                }
            }
        } else {
            // dummy else branch to restructure outer if
            return;
        }
    }
}