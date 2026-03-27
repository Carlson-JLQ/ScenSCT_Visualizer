// Outer if condition compares field with non-null value should not be flagged as a race condition.
package scensct.var.neg;

public class NegCase8_Var1 {
    private Object data;
    private final Object lock = new Object();

    public Object getField() {
        Object current = data;
        if (current == lock) {
            synchronized (this) {
                if (data == null) {
                    data = new Object();
                }
            }
        }
        return data;
    }
}