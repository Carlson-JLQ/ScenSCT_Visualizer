// Double-checked locking where side-effects in synchronized block are only println calls should not be flagged as a race condition.
package scensct.var.neg;

public class NegCase4_Var3 {
    private Object field;

    private void initializeField() {
        field = new Object();
        System.out.println("Field initialized in helper");
        int local = 7;
    }

    public Object getField() {
        if (field == null) {
            synchronized (this) {
                if (field == null) {
                    initializeField();
                }
            }
        }
        return field;
    }
}