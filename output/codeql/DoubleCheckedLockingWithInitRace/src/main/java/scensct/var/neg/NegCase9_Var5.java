// Outer if condition is not an equality test should not be flagged as a race condition.
package scensct.var.neg;

public class NegCase9_Var5 {
    private Object field;

    public Object getField() {
        // Outer condition as a complex boolean expression without equality
        boolean cond = (field != null) || (field == null); // always true, but no equality test in outer if
        if (cond) {
            synchronized (this) {
                if (field == null) {
                    field = new Object();
                }
            }
        }
        return field;
    }
}