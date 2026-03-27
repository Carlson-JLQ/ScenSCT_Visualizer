// Outer if condition reads field via method call (not direct/local/assignment) should not be flagged as a race condition.
package scensct.var.neg;

public class NegCase6_Var3 {
    private Object field;

    private Object fetchField() {
        return field;
    }

    public Object getField() {
        // restructure with do-while false for no effect
        do {
            if (fetchField() != null) {
                break;
            }
            synchronized (this) {
                if (field == null) {
                    field = new Object();
                }
            }
        } while (false);
        return field;
    }
}