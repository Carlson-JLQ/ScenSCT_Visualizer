// A method with outer if null check on non-volatile field and synchronized block but no inner if should not be flagged as double-checked locking.
package scensct.var.neg;

public class NegCase1_Var1 {
    private Object data; // renamed field, still non-volatile
    private final Object lock = new Object(); // explicit lock object

    public void method() {
        if (data == null) { // outer null-check preserved
            synchronized (lock) { // lock on separate object
                // Still no inner null-check
                Object temp = new Object();
                data = temp; // assignment via temporary
            }
        }
    }
}