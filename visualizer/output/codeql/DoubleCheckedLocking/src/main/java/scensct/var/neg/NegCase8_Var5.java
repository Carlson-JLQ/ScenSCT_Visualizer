// A method with null check on f inside synchronized block but not as inner if condition should not be flagged as double-checked locking.
package scensct.var.neg;

public class NegCase8_Var5 {
    private Object f;

    public void method() {
        // outer null check
        if (f == null) {
            // inner logic extracted to a private method
            initField();
        }
    }

    private void initField() {
        synchronized (this) {
            boolean isNull = f == null;
            if (isNull) {
                f = new Object();
            }
        }
    }
}