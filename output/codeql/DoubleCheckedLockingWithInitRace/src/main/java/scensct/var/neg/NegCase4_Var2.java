// Double-checked locking where side-effects in synchronized block are only println calls should not be flagged as a race condition.
package scensct.var.neg;

public class NegCase4_Var2 {
    private Object field;

    public Object getField() {
        if (field == null) {
            synchronized (this) {
                if (field == null) {
                    Object tmp = new Object();
                    System.out.println("Initializing field");
                    field = tmp;
                    int x = 42;
                }
            }
        }
        return field;
    }
}