// Multiplication by zero with all literals should not be flagged as non-constant expression.
package scensct.var.neg;

public class NegCase1_Var5 {
    public static void main(String[] args) {
        // Variant 5: Use multiplication by zero inside a conditional that always takes same branch.
        int x = 5 * 0;
        if (x == 0) {
            System.out.println(x);
        } else {
            // Dead code, never reached.
            System.out.println("impossible");
        }
    }
}