// A method with null check on f not being the outer if condition should not be flagged as double-checked locking.
package scensct.var.neg;

public class NegCase5_Var1 {
    private Object f; // non-volatile field

    public void method() {
        // Outer condition via a method that returns boolean based on f == null
        if (shouldSync()) {
            synchronized (this) {
                if (f == null) {
                    f = new Object();
                }
            }
        }
    }

    private boolean shouldSync() {
        return f == null;
    }
}