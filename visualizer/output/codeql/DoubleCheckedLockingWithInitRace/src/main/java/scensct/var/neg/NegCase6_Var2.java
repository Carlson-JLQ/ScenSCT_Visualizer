// Outer if condition reads field via method call (not direct/local/assignment) should not be flagged as a race condition.
package scensct.var.neg;

public class NegCase6_Var2 {
    private Object field;

    private Object internalGet() {
        return field;
    }

    public Object getField() {
        Object tmp = internalGet(); // introduce temporary
        if (tmp == null) {
            synchronized (this) {
                if (field == null) {
                    field = new Object();
                }
            }
        }
        return field;
    }
}