// Equality test where field access is to a non-float/double type should not be flagged as static NaN comparison.
package scensct.core.neg;

public class NegCase2 {
    static final int MAX_VALUE = 100;
    static final String CONST = "NaN"; // Field name "NaN" but declaring type is String, not float/double

    public static void main(String[] args) {
        boolean test1 = (MAX_VALUE == 100); // Field access to int static field
        boolean test2 = (CONST != "test"); // Field access to String static field with name "NaN"
        System.out.println(test1 + " " + test2);
    }
}