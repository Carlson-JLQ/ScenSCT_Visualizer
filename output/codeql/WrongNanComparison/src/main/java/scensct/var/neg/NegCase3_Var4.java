// Equality test where static field from float/double type is not named "NaN" should not be flagged as static NaN comparison.
package scensct.var.neg;

public class NegCase3_Var4 {
    // Variant 4: Introduce a conditional that doesn't affect the comparison
    public static void main(String[] args) {
        boolean test1, test2;
        if (args.length >= 0) { // always true
            test1 = (Double.POSITIVE_INFINITY == Double.POSITIVE_INFINITY);
        } else {
            test1 = false;
        }
        test2 = (Float.NEGATIVE_INFINITY != 0.0f);
        System.out.println(test1 + " " + test2);
    }
}