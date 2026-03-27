// A method with outer if condition not being == null comparison should not be flagged as double-checked locking.
package scensct.var.neg;

public class NegCase2_Var1 {
    private Object f; // non-volatile field

    public void method() {
        // Variant 1: Outer condition expressed as boolean negation
        boolean isNotNull = f == null ? false : true;
        if (isNotNull) {
            synchronized (this) {
                if (f == null) {
                    f = new Object();
                }
            }
        }
    }
}