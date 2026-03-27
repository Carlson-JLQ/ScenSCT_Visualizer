// A method with outer if condition being == equality but not comparing field to null should not be flagged as double-checked locking.
package scensct.core.neg;

public class NegCase3 {
    private Object f; // non-volatile field

    public void method() {
        Object local = new Object();
        if (f == local) { // outer if compares f to non-null value, not null
            synchronized (this) {
                if (f == null) { // inner if with null check
                    f = new Object();
                }
            }
        }
    }
}