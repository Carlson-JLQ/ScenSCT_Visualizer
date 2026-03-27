// Equality comparison with Float.NaN should be flagged as always false for == and always true for !=.
package scensct.var.pos;

public class PosCase1_Var1 {
    public static void main(String[] args) {
        // Variant 1: Introduce local variables for NaN values, but still direct static field access in assignment.
        float nanFloat = Float.NaN;
        double nanDouble = Double.NaN;
        boolean result1 = (nanFloat == 1.0f); // Should still report: == with Float.NaN via variable
        boolean result2 = (nanDouble != 2.0); // Should still report: != with Double.NaN via variable
        System.out.println(result1 + " " + result2);
    }
}