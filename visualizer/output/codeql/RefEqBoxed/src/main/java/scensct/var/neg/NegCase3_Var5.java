// Reference equality comparison where at least one operand is java.lang.Boolean should not be flagged as suspicious.
package scensct.var.neg;

public class NegCase3_Var5 {
    // Variant 5: Use nested ternary and explicit casts
    public static void main(String[] args) {
        Boolean bool1 = Boolean.parseBoolean("true");
        Boolean bool2 = args.length == 0 ? Boolean.FALSE : Boolean.TRUE;
        Integer intVal = 10 - 5; // results in 5, then autoboxed

        // Boolean == Boolean via ternary
        boolean comp1 = (bool1 == bool2) ? true : false;

        // Boolean == Integer with explicit cast chain
        Object o = intVal;
        Boolean temp = bool1;
        boolean comp2 = temp == o;

        // Integer == Boolean with cast on left
        boolean comp3 = ((Object) intVal) == ((Boolean) bool1);
    }
}