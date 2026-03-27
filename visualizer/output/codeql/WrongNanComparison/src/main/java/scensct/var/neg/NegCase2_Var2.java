// Equality test where field access is to a non-float/double type should not be flagged as static NaN comparison.
package scensct.var.neg;

public class NegCase2_Var2 {
    static final int MAX_VALUE = 100;
    static final String CONST = "NaN";

    private static boolean checkIntEquality(int a, int b) {
        return a == b; // Helper method for int comparison
    }

    private static boolean checkStringInequality(String s1, String s2) {
        return s1 != s2; // Helper method for reference inequality
    }

    public static void main(String[] args) {
        // Variant 2: Move comparisons into static helper methods
        boolean test1 = checkIntEquality(MAX_VALUE, 100);
        boolean test2 = checkStringInequality(CONST, "test");
        System.out.println(test1 + " " + test2);
    }
}