// Outer if condition compares field with non-null value should not be flagged as a race condition.
package scensct.var.neg;

public class NegCase8_Var3 {
    private Object field;
    private final Object otherField = new Object();

    public Object getField() {
        boolean shouldEnter = (field != null) && field.equals(otherField);
        if (shouldEnter) {
            synchronized (this) {
                if (field == null) {
                    field = new Object();
                }
            }
        }
        return field;
    }
}