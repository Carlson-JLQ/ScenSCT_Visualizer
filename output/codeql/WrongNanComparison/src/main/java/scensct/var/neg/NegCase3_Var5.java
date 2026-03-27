// Equality test where static field from float/double type is not named "NaN" should not be flagged as static NaN comparison.
package scensct.var.neg;

public class NegCase3_Var5 {
    // Variant 5: Use Double.compare and Float.compare for equality check (but still not NaN)
    // Note: compare returns 0 for equal, non-zero for unequal. We convert to boolean.
    public static void main(String[] args) {
        boolean test1 = Double.compare(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY) == 0;
        boolean test2 = Float.compare(Float.NEGATIVE_INFINITY, 0.0f) != 0;
        System.out.println(test1 + " " + test2);
    }
}