// Outer if condition reads field via method call (not direct/local/assignment) should not be flagged as a race condition.
package scensct.var.neg;

public class NegCase6_Var1 {
    private Object field;

    private Object retrieveField() { // renamed method
        return field;
    }

    public Object getField() {
        if (retrieveField() == null) { // lexical reorder
            synchronized (this) {
                if (field == null) {
                    field = new Object();
                }
            }
        }
        return field;
    }
}