// Double-checked locking where side-effects in synchronized block are only println calls should not be flagged as a race condition.
package scensct.var.neg;

public class NegCase4_Var5 {
    private Object field;

    public Object getField() {
        if (field == null) {
            synchronized (this) {
                if (field == null) {
                    do {
                        field = new Object();
                        System.out.println("Field set in do-while");
                        int local = 99;
                    } while (false);
                }
            }
        }
        return field;
    }
}