// Inner if condition is not an equality test should not be flagged as a race condition.
package scensct.var.neg;

public class NegCase7_Var1 {
    private Object data;
    private int status = 1;

    public Object getField() {
        if (data == null) {
            synchronized (this) {
                if (status > 0) { // not equality on 'data'
                    data = new Object();
                }
            }
        }
        return data;
    }
}