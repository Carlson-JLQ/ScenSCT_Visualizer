// A multiplication expression as left operand of division, nested inside outer binary expression should not be flagged as nested binary operator with misleading whitespace.
package scensct.var.neg;

public class NegCase3_Var4 {
    public static void main(String[] args) {
        int[] coeffs = {2, 3, 4};
        int x = 10;
        // compute a*b/c in steps but same logical grouping
        int numerator = coeffs[0] * coeffs[1];
        int denominator = coeffs[2];
        int result = x + numerator / denominator;
        System.out.println(result);
    }
}