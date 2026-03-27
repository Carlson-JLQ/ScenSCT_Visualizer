// A method with null check on f inside synchronized block but not as inner if condition should not be flagged as double-checked locking.
package scensct.core.neg;

public class NegCase8 {
    private Object f; // non-volatile field

    public void method() {
        if (f == null) { // outer if null check on f
            synchronized (this) {
                // Null check on f exists but not as inner if condition
                boolean check = (f == null);
                if (check) { // inner if condition is not direct null check
                    f = new Object();
                }
            }
        }
    }
}