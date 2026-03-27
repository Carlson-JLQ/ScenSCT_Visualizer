// A method implementing double-checked locking with volatile field should not be flagged as unsafe.
package scensct.var.neg;

public class NegCase9_Var5 {
    private volatile Object f;

    public void method() {
        try {
            if (f == null) {
                synchronized (this) {
                    if (f == null) {
                        f = new Object();
                    }
                }
            }
        } finally {
            // harmless side-effect-free finally block
            int x = 1;
        }
    }
}