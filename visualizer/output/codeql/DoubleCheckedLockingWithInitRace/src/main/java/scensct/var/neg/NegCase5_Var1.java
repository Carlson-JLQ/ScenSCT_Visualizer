// Outer if condition is inequality (false polarity) should not be flagged as a race condition.
package scensct.var.neg;

public class NegCase5_Var1 {
    private Object data;

    public Object getField() {
        if (null != data) { // outer inequality with swapped operands
            synchronized (this) {
                if (data == null) {
                    data = new Object();
                }
            }
        }
        return data;
    }
}