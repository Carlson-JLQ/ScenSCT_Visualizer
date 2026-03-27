// Outer if condition compares field with non-null value should not be flagged as a race condition.
package scensct.var.neg;

public class NegCase8_Var4 {
    private Object field;
    private final Object marker = Integer.valueOf(42);

    public Object getField() {
        while (field == marker) {
            synchronized (this) {
                if (field == null) {
                    field = new Object();
                }
                break;
            }
        }
        return field;
    }
}