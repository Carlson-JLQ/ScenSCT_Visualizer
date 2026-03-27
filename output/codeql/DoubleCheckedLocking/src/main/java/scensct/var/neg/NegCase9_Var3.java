// A method implementing double-checked locking with volatile field should not be flagged as unsafe.
package scensct.var.neg;

public class NegCase9_Var3 {
    private volatile Object f;

    private boolean isFieldNull() {
        return f == null;
    }

    private void initializeField() {
        synchronized (this) {
            if (f == null) {
                f = new Object();
            }
        }
    }

    public void method() {
        if (isFieldNull()) {
            initializeField();
        }
    }
}