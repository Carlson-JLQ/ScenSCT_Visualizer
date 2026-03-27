// Outer if condition compares field with non-null value should not be flagged as a race condition.
package scensct.var.neg;

public class NegCase8_Var5 {
    private Object field;
    private static final Object NON_NULL_REF = new Object();

    public Object getField() {
        if (NON_NULL_REF.equals(field)) {
            return field;
        }
        if (field == NON_NULL_REF) {
            synchronized (this) {
                if (field == null) {
                    field = new Object();
                }
            }
        }
        return field;
    }
}