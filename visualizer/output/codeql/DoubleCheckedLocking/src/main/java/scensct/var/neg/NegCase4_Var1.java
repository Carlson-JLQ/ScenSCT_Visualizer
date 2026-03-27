// A method with outer if null check on a different field should not be flagged as double-checked locking on field f.
package scensct.var.neg;

public class NegCase4_Var1 {
    private Object f;
    private Object g;

    public void method() {
        // Inverted outer check with early return
        if (g != null) {
            return;
        }
        synchronized (this) {
            if (f == null) {
                f = new Object();
            }
        }
    }
}