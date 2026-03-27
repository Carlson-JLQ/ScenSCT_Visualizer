// A method with null check on f inside synchronized block but not as inner if condition should not be flagged as double-checked locking.
package scensct.var.neg;

public class NegCase8_Var4 {
    private Object f;

    public void method() {
        // outer null check with inverted condition early return
        if (f != null) return;
        synchronized (this) {
            // compute condition via ternary
            boolean check = f != null ? false : true;
            if (check) {
                f = new Object();
            }
        }
    }
}