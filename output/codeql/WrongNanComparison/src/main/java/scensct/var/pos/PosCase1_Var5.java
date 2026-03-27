// Equality comparison with Float.NaN should be flagged as always false for == and always true for !=.
package scensct.var.pos;

public class PosCase1_Var5 {
    public static void main(String[] args) {
        // Variant 5: Use the comparison as part of a larger expression, with explicit casting.
        boolean result1 = ((Float) Float.NaN == (Float) 1.0f); // Should still report: == with Float.NaN, boxed then unboxed
        boolean result2 = (Double.NaN != (double) 2.0f); // Should still report: != with Double.NaN, with cast // [REPORTED LINE]
        System.out.println(result1 + " " + result2);
    }
}