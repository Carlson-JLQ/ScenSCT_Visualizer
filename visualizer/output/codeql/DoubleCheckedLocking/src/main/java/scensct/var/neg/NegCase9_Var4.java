// A method implementing double-checked locking with volatile field should not be flagged as unsafe.
package scensct.var.neg;

public class NegCase9_Var4 {
    private volatile Object f;

    public void method() {
        // loop instead of single if, but same semantics
        while (f == null) {
            synchronized (this) {
                if (f == null) {
                    f = new Object();
                }
                break;
            }
        }
    }
}