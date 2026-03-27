// Reference equality comparison where at least one operand is java.lang.Boolean should not be flagged as suspicious.
package scensct.var.neg;

public class NegCase3_Var2 {
    public static void main(String[] args) {
        // Variant 2: Introduce control flow and temporary variables
        Boolean b1 = args.length > 0 ? Boolean.TRUE : Boolean.FALSE;
        Boolean b2 = Boolean.FALSE;
        Integer i = 5; // autoboxing

        boolean cmp;
        if (b1 != null) {
            cmp = b1 == b2; // Boolean == Boolean
        } else {
            cmp = false;
        }

        Object o1 = b1;
        Object o2 = (Object) i;
        boolean cmp2 = o1 == o2; // Boolean (via Object) == Integer (via Object)

        boolean cmp3 = ((Object) i) == b1; // Integer == Boolean
    }
}