// Comparing different integer literals should not be flagged as identical operand comparison.
package scensct.var.neg;

public class NegCase1_Var1 {
    public static void main(String[] args) {
        int x = 5;
        int y = 10;
        // Use temporaries and arithmetic to obscure direct literals
        int temp1 = x;
        int temp2 = y;
        boolean result = (temp1 + 0 == temp2 - 0);
        // Swap variable names and use explicit casting
        boolean result2 = ((int) y == (int) x);
        // Introduce a conditional that doesn't change values
        if (x < y) {
            boolean lt = (x < y);
        }
        // Use a loop to set up comparisons (loop does not alter distinctness)
        for (int i = 0; i < 1; i++) {
            boolean gt = (y > x);
        }
        // Extract comparisons to a helper method
        boolean le = lessOrEqual(x, y);
        boolean ge = greaterOrEqual(x, y);
        boolean ne = notEqual(x, y);
    }
    
    private static boolean lessOrEqual(int p, int q) {
        return p <= q;
    }
    
    private static boolean greaterOrEqual(int p, int q) {
        return p >= q;
    }
    
    private static boolean notEqual(int p, int q) {
        return p != q;
    }
}