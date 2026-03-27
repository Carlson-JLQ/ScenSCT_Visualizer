// Reference equality comparison where left operand is boxed numeric and right operand is not a boxed numeric type should not be flagged as suspicious.
package scensct.core.neg;

public class NegCase2 {
    public static void main(String[] args) {
        Integer leftInt = Integer.valueOf(10);

        // Scenario 2: right operand is primitive int
        boolean comp1 = (leftInt == 10); // right is primitive, not boxed

        // right operand is String
        boolean comp2 = (leftInt == (Object) "10"); // right is String, not boxed numeric

        // right operand is Boolean
        Boolean bool = Boolean.TRUE;
        boolean comp3 = (leftInt == (Object) bool); // right is Boolean, not boxed numeric

        // right operand is null
        boolean comp4 = (leftInt == null); // right is null, not boxed numeric
    }
}