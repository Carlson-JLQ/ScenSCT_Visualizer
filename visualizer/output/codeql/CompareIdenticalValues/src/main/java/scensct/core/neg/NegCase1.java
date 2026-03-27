// Comparing different integer literals should not be flagged as identical operand comparison.
package scensct.core.neg;

public class NegCase1 {
    public static void main(String[] args) {
        int a = 5;
        int b = 10;
        // Scenario 1: Different literals (5 and 10) are not identical in value.
        boolean result = (5 == 10);
        // Also test with different variables (a and b).
        boolean result2 = (a == b);
        // Test other comparison operators with non-identical operands.
        boolean lt = (a < b);
        boolean gt = (a > b);
        boolean le = (a <= b);
        boolean ge = (a >= b);
        boolean ne = (a != b);
    }
}