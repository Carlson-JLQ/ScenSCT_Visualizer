// A method implementing double-checked locking with volatile field should not be flagged as unsafe.
package scensct.var.neg;

public class NegCase9_Var2 {
    private volatile Object f;

    public void method() {
        // outer check restructured with a temporary variable
        boolean needSync = (f == null);
        if (needSync) {
            synchronized (this) {
                Object tmp = f;
                if (tmp == null) {
                    f = new Object();
                }
            }
        }
    }
}