// A method with null check on f not being the outer if condition should not be flagged as double-checked locking.
package scensct.var.neg;

public class NegCase5_Var3 {
    private Object f; // non-volatile field

    public void method() {
        // Use a ternary to decide whether to enter synchronized block, but outer guard is still indirect
        boolean check = f == null ? true : false;
        if (check && !Thread.currentThread().isInterrupted()) {
            synchronized (this) {
                if (f == null) {
                    f = new Object();
                }
            }
        }
    }
}