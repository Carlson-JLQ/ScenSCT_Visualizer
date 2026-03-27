// Reference equality comparison where at least one operand is java.lang.Boolean should not be flagged as suspicious.
package scensct.var.neg;

public class NegCase3_Var1 {
    public static void main(String[] args) {
        Boolean flagA = Boolean.valueOf(true);
        Boolean flagB = Boolean.valueOf(false);
        Number num = Integer.valueOf(5);

        // Variant 1: Use method calls to obtain Booleans and restructure comparisons
        boolean result1 = areEqualRefs(flagA, flagB); // Boolean == Boolean
        boolean result2 = isSameAsInt(flagA, num);    // Boolean == Integer via Object
        boolean result3 = compareMixed(num, flagA);   // Integer == Boolean via Object
    }

    private static boolean areEqualRefs(Boolean a, Boolean b) {
        return a == b;
    }

    private static boolean isSameAsInt(Boolean b, Number n) {
        Object obj = n;
        return b == obj;
    }

    private static boolean compareMixed(Number n, Boolean b) {
        Object left = n;
        return left == b;
    }
}