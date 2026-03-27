// A method with outer if condition being == equality but not comparing field to null should not be flagged as double-checked locking.
package scensct.var.neg;

public class NegCase3_Var4 {
    private Object f; // non-volatile field

    public void method() {
        Object local = new Object();
        if (local.equals(f)) { // outer if uses equals, still not f == null
            synchronized (this) {
                if (f == null) {
                    f = new Object();
                }
            }
        }
    }
}