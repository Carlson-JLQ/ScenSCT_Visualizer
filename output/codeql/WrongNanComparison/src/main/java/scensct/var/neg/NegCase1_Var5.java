// Equality test where neither operand is a field access expression should not be flagged as static NaN comparison.
package scensct.var.neg;

public class NegCase1_Var5 {
    public static void main(String[] args) {
        // Variant 5: Complex expression with parentheses and casting
        double val = (double) (Float.NaN); // Cast from float NaN
        double tmp = val + 0.0; // Stays NaN
        boolean r = (tmp == val); // Both are local variables
        System.out.println(r);
    }
}