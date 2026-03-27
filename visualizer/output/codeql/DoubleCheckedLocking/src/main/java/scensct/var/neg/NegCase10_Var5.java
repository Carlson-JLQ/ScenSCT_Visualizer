// A method implementing double-checked locking on non-volatile field of immutable type should not be flagged as unsafe.
package scensct.var.neg;

public class NegCase10_Var5 {
    private String f;

    private void initUnderLock() {
        if (f == null) { // inner check moved to helper, but still under same lock
            f = "value";
        }
    }

    public void method() {
        if (f == null) {
            synchronized (this) {
                initUnderLock(); // inter-procedural refactoring
            }
        }
    }
}