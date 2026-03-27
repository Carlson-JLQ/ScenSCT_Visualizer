// A method with outer if condition being == equality but not comparing field to null should not be flagged as double-checked locking.
package scensct.var.neg;

public class NegCase3_Var2 {
    private Object f; // non-volatile field

    public void method() {
        Object local = new Object();
        boolean outerCondition = (f == local);
        if (outerCondition) {
            // empty then block
        } else {
            return;
        }
        synchronized (this) {
            if (f == null) {
                f = new Object();
            }
        }
    }
}