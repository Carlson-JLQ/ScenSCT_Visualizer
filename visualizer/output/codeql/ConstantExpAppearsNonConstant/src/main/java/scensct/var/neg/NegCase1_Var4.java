// Multiplication by zero with all literals should not be flagged as non-constant expression.
package scensct.var.neg;

public class NegCase1_Var4 {
    public static void main(String[] args) {
        // Variant 4: Split into temporary variables that hold literals.
        final int a = 5;
        final int b = 0;
        int result = a * b;
        System.out.println(result);
    }
}