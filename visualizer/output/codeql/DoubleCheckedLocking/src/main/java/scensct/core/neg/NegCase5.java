// A method with null check on f not being the outer if condition should not be flagged as double-checked locking.
package scensct.core.neg;

public class NegCase5 {
    private Object f; // non-volatile field

    public void method() {
        // Null check on f exists but not as outer if condition
        boolean check = (f == null);
        if (check) { // outer if condition is not direct null check
            synchronized (this) {
                if (f == null) { // inner if with null check
                    f = new Object();
                }
            }
        }
    }
}