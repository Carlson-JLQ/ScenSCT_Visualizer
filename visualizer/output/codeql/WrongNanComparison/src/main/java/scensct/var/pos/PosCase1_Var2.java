// Equality comparison with Float.NaN should be flagged as always false for == and always true for !=.
package scensct.var.pos;

public class PosCase1_Var2 {
    // Helper method returning Float.NaN
    static float getFloatNaN() {
        return Float.NaN;
    }
    
    // Helper method returning Double.NaN
    static double getDoubleNaN() {
        return Double.NaN;
    }
    
    public static void main(String[] args) {
        // Variant 2: Use method calls that return the static NaN fields.
        boolean result1 = (getFloatNaN() == 1.0f); // Should still report: == via method returning Float.NaN
        boolean result2 = (getDoubleNaN() != 2.0); // Should still report: != via method returning Double.NaN
        System.out.println(result1 + " " + result2);
    }
}