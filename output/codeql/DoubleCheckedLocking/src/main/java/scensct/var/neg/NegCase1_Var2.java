// A method with outer if null check on non-volatile field and synchronized block but no inner if should not be flagged as double-checked locking.
package scensct.var.neg;

public class NegCase1_Var2 {
    private Object f;

    public void method() {
        boolean shouldInitialize = (f == null); // outer check stored in variable
        if (shouldInitialize) {
            synchronized (this) {
                // No inner if
                f = createDefault(); // assignment via method call
            }
        }
    }

    private Object createDefault() {
        return new Object();
    }
}