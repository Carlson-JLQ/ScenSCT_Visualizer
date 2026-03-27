// Equality test where field access is to a non-float/double type should not be flagged as static NaN comparison.
package scensct.var.neg;

public class NegCase2_Var4 {
    static final int MAX_VALUE = 100;
    static final String CONST = "NaN";

    public static void main(String[] args) {
        // Variant 4: Use wrapper types and explicit unboxing/casting
        Integer boxed = MAX_VALUE; // Autoboxing from static int field
        boolean test1 = (boxed.intValue() == 100); // Unboxed comparison
        boolean test2 = ((Object) CONST != (Object) "test"); // Explicit reference comparison
        System.out.println(test1 + " " + test2);
    }
}