// Outer if condition is not an equality test should not be flagged as a race condition.
package scensct.var.neg;

public class NegCase9_Var1 {
    private Object field;

    public Object getField() {
        boolean flag = System.currentTimeMillis() > 0; // non-equality boolean expression
        if (flag) {
            synchronized (this) {
                if (field == null) {
                    field = new Object();
                }
            }
        }
        return field;
    }
}