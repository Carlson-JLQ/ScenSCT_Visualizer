// Equality test where static field from float/double type is not named "NaN" should not be flagged as static NaN comparison.
package scensct.var.neg;

public class NegCase3_Var2 {
    // Variant 2: Use method calls that return the static field values (non-NaN)
    private static double getPosInf() {
        return Double.POSITIVE_INFINITY;
    }
    private static float getNegInf() {
        return Float.NEGATIVE_INFINITY;
    }
    public static void main(String[] args) {
        boolean test1 = (getPosInf() == Double.POSITIVE_INFINITY);
        boolean test2 = (getNegInf() != 0.0f);
        System.out.println(test1 + " " + test2);
    }
}