// Comparing different integer literals should not be flagged as identical operand comparison.
package scensct.var.neg;

public class NegCase1_Var3 {
    public static void main(String[] args) {
        // Split declarations and assignments
        int a;
        a = 5;
        int b = 10;
        // Use final variables
        final int constA = a;
        final int constB = b;
        boolean result = (constA == constB);
        // Compare using method parameters (pass distinct values)
        boolean result2 = compareValues(a, b);
        // Use a while loop that runs once
        int count = 0;
        boolean lt = false;
        while (count < 1) {
            lt = (a < b);
            count++;
        }
        // Compare via Math.max/min (indirectly)
        boolean gt = (Math.max(a, b) == b);
        boolean le = (Math.min(a, b) == a);
        // Use ternary operator to produce distinct operands
        boolean ge = (a >= b ? false : true); // This is a different expression, but still compares a and b
        boolean ne = (a != b);
    }
    
    private static boolean compareValues(int x, int y) {
        return x == y;
    }
}