// Multiplication by zero with all literals should not be flagged as non-constant expression.
package scensct.var.neg;

public class NegCase1_Var1 {
    public static void main(String[] args) {
        // Variant 1: Reorder operands and add parentheses, still literal 0.
        int result = 0 * 5;
        System.out.println(result);
    }
}