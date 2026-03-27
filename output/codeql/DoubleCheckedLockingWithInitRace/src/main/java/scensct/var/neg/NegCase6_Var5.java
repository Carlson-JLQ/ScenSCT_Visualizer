// Outer if condition reads field via method call (not direct/local/assignment) should not be flagged as a race condition.
package scensct.var.neg;

import java.util.Optional;

public class NegCase6_Var5 {
    private Object field;

    private Optional<Object> getFieldOpt() { // idiomatic Optional wrapper
        return Optional.ofNullable(field);
    }

    public Object getField() {
        if (!getFieldOpt().isPresent()) { // still a method call
            synchronized (this) {
                if (field == null) {
                    field = new Object();
                }
            }
        }
        return field;
    }
}