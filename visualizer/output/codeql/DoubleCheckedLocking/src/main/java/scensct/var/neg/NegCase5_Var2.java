// A method with null check on f not being the outer if condition should not be flagged as double-checked locking.
package scensct.var.neg;

public class NegCase5_Var2 {
    private Object f; // non-volatile field

    public void method() {
        // Outer condition is a compound boolean expression where f == null is nested
        boolean flag = (f == null) && Math.random() > 0.5;
        if (flag) {
            synchronized (this) {
                if (f == null) {
                    f = new Object();
                }
            }
        }
    }
}