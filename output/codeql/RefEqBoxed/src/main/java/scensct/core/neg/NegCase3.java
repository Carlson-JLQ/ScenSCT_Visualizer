// Reference equality comparison where at least one operand is java.lang.Boolean should not be flagged as suspicious.
package scensct.core.neg;

public class NegCase3 {
    public static void main(String[] args) {
        Boolean bool1 = Boolean.TRUE;
        Boolean bool2 = Boolean.FALSE;
        Integer intVal = Integer.valueOf(5);

        // Scenario 3: both operands are Boolean
        boolean comp1 = (bool1 == bool2); // Boolean == Boolean, excluded

        // Boolean == Integer
        boolean comp2 = (bool1 == (Object) intVal); // at least one is Boolean, excluded

        // Integer == Boolean (left is boxed numeric, right is Boolean)
        boolean comp3 = ((Object) intVal == bool1); // at least one is Boolean, excluded
    }
}