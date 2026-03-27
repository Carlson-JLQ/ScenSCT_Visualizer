// Dereference in block guarded by null check where variable is known non-null (unreachable) should not be flagged as always null.
package scensct.var.neg;

import java.util.Objects;

public class NegCase6_Var2 {
    public static void main(String[] args) {
        // Variant 2: Use Objects.requireNonNull for initialization and a boolean guard
        Object item = Objects.requireNonNull(new Object());
        boolean isNull = (item == null);
        if (isNull) {
            // Unreachable because isNull is false
            System.out.println(item.toString()); // [REPORTED LINE]
        }
    }
}