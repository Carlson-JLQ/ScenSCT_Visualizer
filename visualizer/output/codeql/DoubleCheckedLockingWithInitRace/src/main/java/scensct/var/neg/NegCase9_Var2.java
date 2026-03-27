// Outer if condition is not an equality test should not be flagged as a race condition.
package scensct.var.neg;

public class NegCase9_Var2 {
    private Object field;

    public Object getField() {
        // Outer condition as a method call returning boolean
        if (alwaysTrue()) {
            synchronized (this) {
                Object temp = field;
                if (temp == null) {
                    field = new Object();
                }
            }
        }
        return field;
    }

    private boolean alwaysTrue() {
        return true;
    }
}