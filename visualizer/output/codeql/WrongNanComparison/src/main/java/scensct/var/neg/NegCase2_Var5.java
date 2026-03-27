// Equality test where field access is to a non-float/double type should not be flagged as static NaN comparison.
package scensct.var.neg;

public class NegCase2_Var5 {
    static final int MAX_VALUE = 100;
    static final String CONST = "NaN";

    public static void main(String[] args) {
        // Variant 5: Compound expressions and side-effect-free computations
        boolean test1 = ((MAX_VALUE * 1) / 1) == 100; // Arithmetic preserving int type
        boolean test2 = !(CONST.equals("test")); // Logical negation of equals, semantically !=
        // Combine outputs in a different way
        String result = Boolean.toString(test1) + " " + Boolean.toString(test2);
        System.out.println(result);
    }
}