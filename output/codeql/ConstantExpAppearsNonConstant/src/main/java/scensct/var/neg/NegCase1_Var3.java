// Multiplication by zero with all literals should not be flagged as non-constant expression.
package scensct.var.neg;

public class NegCase1_Var3 {
    public static void main(String[] args) {
        // Variant 3: Embed the multiplication in a larger constant expression.
        int result = 10 + (5 * 0) - 10;
        System.out.println(result);
    }
}