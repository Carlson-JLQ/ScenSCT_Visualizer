// A method with inner if null check on a different field should not be flagged as double-checked locking on field f.
package scensct.var.neg;

public class NegCase7_Var4 {
    private Object f;
    private Object g;

    public void method() {
        if (f == null) {
            Object tmp = null;
            synchronized (this) {
                if (g == null) {
                    tmp = new Object();
                }
            }
            if (tmp != null) {
                f = tmp;
            }
        }
    }
}