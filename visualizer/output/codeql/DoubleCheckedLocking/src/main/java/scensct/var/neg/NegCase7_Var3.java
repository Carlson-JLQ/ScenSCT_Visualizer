// A method with inner if null check on a different field should not be flagged as double-checked locking on field f.
package scensct.var.neg;

public class NegCase7_Var3 {
    private Object f;
    private Object g;

    public void method() {
        if (f == null) {
            synchronized (this) {
                if (checkG()) {
                    f = new Object();
                }
            }
        }
    }

    private boolean checkG() {
        return g == null;
    }
}