// Multiplication by zero with all literals should not be flagged as non-constant expression.
package scensct.core.neg;

public class NegCase1 {
    public static void main(String[] args) {
        // Scenario 1: Expression is a constant-folding expression (multiplication by zero) with all child expressions as literals.
        int result = 5 * 0; // Compile-time constant: 0
        System.out.println(result);
    }
}