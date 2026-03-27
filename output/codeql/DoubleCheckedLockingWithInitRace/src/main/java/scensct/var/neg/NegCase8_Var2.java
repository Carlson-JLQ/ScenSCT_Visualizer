// Outer if condition compares field with non-null value should not be flagged as a race condition.
package scensct.var.neg;

public class NegCase8_Var2 {
    private volatile Object field;
    private final Object constant = "CONST";

    private boolean isFieldEqualToConstant() {
        return field == constant;
    }

    public Object getField() {
        if (isFieldEqualToConstant()) {
            synchronized (this) {
                if (field == null) {
                    field = new Object();
                }
            }
        }
        return field;
    }
}