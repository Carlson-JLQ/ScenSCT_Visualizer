// Equality test where static field from float/double type is not named "NaN" should not be flagged as static NaN comparison.
package scensct.core.neg;

public class NegCase3 {
    public static void main(String[] args) {
        // Accessing static fields of floating-point types that are not "NaN"
        boolean test1 = (Double.POSITIVE_INFINITY == Double.POSITIVE_INFINITY);
        boolean test2 = (Float.NEGATIVE_INFINITY != 0.0f);
        System.out.println(test1 + " " + test2);
    }
}