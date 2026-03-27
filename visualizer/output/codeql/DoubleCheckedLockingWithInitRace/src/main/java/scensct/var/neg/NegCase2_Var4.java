// Double-checked locking with no side-effects besides assignment in synchronized block should not be flagged as a race condition.
package scensct.var.neg;

public class NegCase2_Var4 {
    private Object field;

    public Object getField() {
        if (field == null) {
            initField();
        }
        return field;
    }

    private void initField() {
        synchronized (this) {
            if (field == null) {
                field = new Object(); // extracted synchronized block into method
            }
        }
    }
}