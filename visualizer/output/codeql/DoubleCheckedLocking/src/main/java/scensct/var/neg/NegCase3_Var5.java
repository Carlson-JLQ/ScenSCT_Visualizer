// A method with outer if condition being == equality but not comparing field to null should not be flagged as double-checked locking.
package scensct.var.neg;

public class NegCase3_Var5 {
    private Object f; // non-volatile field

    public void method() {
        Object local = new Object();
        int count = 0;
        while (count < 1) {
            if (f == local) {
                synchronized (this) {
                    if (f == null) {
                        f = new Object();
                    }
                }
            }
            count++;
        }
    }
}