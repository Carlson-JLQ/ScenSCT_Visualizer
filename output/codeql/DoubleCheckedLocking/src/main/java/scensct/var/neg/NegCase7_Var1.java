// A method with inner if null check on a different field should not be flagged as double-checked locking on field f.
package scensct.var.neg;

public class NegCase7_Var1 {
    private Object f;
    private Object g;

    public void method() {
        boolean outerCheck = f == null;
        if (outerCheck) {
            synchronized (this) {
                boolean innerCheck = g == null;
                if (innerCheck) {
                    f = new Object();
                }
            }
        }
    }
}