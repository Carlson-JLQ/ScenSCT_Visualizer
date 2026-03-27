// A method with outer if condition not being == null comparison should not be flagged as double-checked locking.
package scensct.var.neg;

public class NegCase2_Var2 {
    private Object f; // non-volatile field

    public void method() {
        // Variant 2: Outer condition uses a temporary variable and reversed operand order
        if (null != f) {
            Object lock = this;
            synchronized (lock) {
                if (f == null) {
                    f = new Object();
                }
            }
        }
    }
}