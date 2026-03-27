// Equality test where static field from float/double type is not named "NaN" should not be flagged as static NaN comparison.
package scensct.var.neg;

public class NegCase3_Var3 {
    // Variant 3: Swap order of operands and use parentheses differently
    public static void main(String[] args) {
        boolean test1 = Double.POSITIVE_INFINITY == Double.POSITIVE_INFINITY;
        boolean test2 = 0.0f != Float.NEGATIVE_INFINITY; // swapped
        System.out.println(test1 + " " + test2);
    }
}