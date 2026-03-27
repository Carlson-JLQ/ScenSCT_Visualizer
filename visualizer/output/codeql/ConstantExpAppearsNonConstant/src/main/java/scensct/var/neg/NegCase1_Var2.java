// Multiplication by zero with all literals should not be flagged as non-constant expression.
package scensct.var.neg;

public class NegCase1_Var2 {
    public static void main(String[] args) {
        // Variant 2: Use zero as a literal long, with explicit cast.
        int result = (int) (5 * 0L);
        System.out.println(result);
    }
}