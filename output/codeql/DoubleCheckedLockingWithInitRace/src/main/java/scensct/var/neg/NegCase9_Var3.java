// Outer if condition is not an equality test should not be flagged as a race condition.
package scensct.var.neg;

public class NegCase9_Var3 {
    private Object field;

    public Object getField() {
        // Use a while loop to wrap the synchronized block, with a break condition
        while (true) {
            synchronized (this) {
                if (field == null) {
                    field = new Object();
                }
            }
            break;
        }
        return field;
    }
}