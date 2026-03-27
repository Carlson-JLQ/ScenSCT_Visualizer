// Reference equality comparison where left operand is not a boxed numeric type should not be flagged as suspicious.
package scensct.var.neg;

public class NegCase1_Var1 {
    // Variant 1: Lexical and control-flow refactoring with temporary variables and loops
    public static void main(String[] args) {
        int primitiveVal = 5;
        for (int i = 0; i < 1; i++) {
            int anotherPrimitive = primitiveVal;
            boolean comp1 = (primitiveVal == anotherPrimitive); // primitive, unchanged
        }

        String text = "hello";
        String identicalText = text.intern();
        boolean comp2 = (text == identicalText); // String ref, still safe

        Boolean flag = Boolean.valueOf(true);
        Boolean sameFlag = Boolean.TRUE;
        if (flag == sameFlag) { // Boolean, excluded
            System.out.println("Boolean match");
        }

        Object instance1 = new Object();
        Object instance2 = instance1;
        boolean comp4 = (instance1 != instance2); // negated, custom object
    }
}