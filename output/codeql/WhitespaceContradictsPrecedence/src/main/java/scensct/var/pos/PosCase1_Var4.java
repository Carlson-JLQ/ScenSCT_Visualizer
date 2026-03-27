// Scenario 1: Binary operator with more whitespace around inner higher-precedence operator should be flagged as misleading spacing.
package scensct.var.pos;

public class PosCase1_Var4 {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 3;
        int result = compute(a, b, c);
    }

    private static int compute(int p, int q, int r) {
        return p + q   * r; // Misleading spacing moved to helper method // [REPORTED LINE]
    }
}