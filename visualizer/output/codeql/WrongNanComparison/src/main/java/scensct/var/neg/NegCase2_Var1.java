// Equality test where field access is to a non-float/double type should not be flagged as static NaN comparison.
package scensct.var.neg;

public class NegCase2_Var1 {
    static final int MAX_VALUE = 100;
    static final String CONST = "NaN";

    public static void main(String[] args) {
        // Variant 1: Introduce temporaries and swap operand order
        int temp = MAX_VALUE;
        boolean test1 = (100 == temp); // Reversed order, still int static field
        String str = CONST;
        boolean test2 = !"test".equals(str); // Use equals but preserve != semantics via negation
        System.out.println(test1 + " " + test2);
    }
}