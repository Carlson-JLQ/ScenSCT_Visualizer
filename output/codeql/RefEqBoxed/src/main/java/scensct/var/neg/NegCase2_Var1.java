// Reference equality comparison where left operand is boxed numeric and right operand is not a boxed numeric type should not be flagged as suspicious.
package scensct.var.neg;

public class NegCase2_Var1 {
    public static void main(String[] args) {
        Integer boxedVal = Integer.valueOf(10);
        int primitive = 10;
        String text = "10";
        Boolean flag = Boolean.TRUE;
        
        // restructured with explicit temporaries and if-else
        if (args.length > 0) {
            boolean test1 = boxedVal == primitive;          // primitive int
            boolean test2 = boxedVal != (Object) text;      // String, using !=
            boolean test3 = (Object) boxedVal == flag;      // Boolean, swapped
            boolean test4 = null == boxedVal;               // null, swapped
        }
    }
}