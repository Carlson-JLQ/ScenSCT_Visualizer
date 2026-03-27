// A method with outer if condition being == equality but not comparing field to null should not be flagged as double-checked locking.
package scensct.var.neg;

public class NegCase3_Var3 {
    private Object f; // non-volatile field

    public void method() {
        Object local = new Object();
        if (shouldEnter(local)) {
            synchronized (this) {
                if (f == null) {
                    f = new Object();
                }
            }
        }
    }

    private boolean shouldEnter(Object obj) {
        return f == obj; // still comparing field to non-null
    }
}