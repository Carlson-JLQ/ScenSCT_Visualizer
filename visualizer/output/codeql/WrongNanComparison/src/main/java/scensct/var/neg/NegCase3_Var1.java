// Equality test where static field from float/double type is not named "NaN" should not be flagged as static NaN comparison.
package scensct.var.neg;

public class NegCase3_Var1 {
    // Variant 1: Extract static field accesses into local variables before comparison
    public static void main(String[] args) {
        double posInf = Double.POSITIVE_INFINITY;
        float negInf = Float.NEGATIVE_INFINITY;
        boolean test1 = (posInf == Double.POSITIVE_INFINITY);
        boolean test2 = (negInf != 0.0f);
        System.out.println(test1 + " " + test2);
    }
}