// Comparing different integer literals should not be flagged as identical operand comparison.
package scensct.var.neg;

public class NegCase1_Var5 {
    public static void main(String[] args) {
        // Use different integer types (but same values)
        short s = 5;
        byte bt = 10;
        int a = s;
        int b = bt;
        boolean result = (s == bt); // Promoted to int, still distinct
        // Use compound assignment that doesn't change value
        a += 0;
        b *= 1;
        boolean result2 = (a == b);
        // Compare inside a synchronized block (no locking effect)
        Object lock = new Object();
        synchronized (lock) {
            boolean lt = (a < b);
        }
        // Use a for-each loop over an array of pairs
        int[][] pairs = {{5, 10}};
        boolean gt = false;
        for (int[] pair : pairs) {
            gt = (pair[1] > pair[0]);
        }
        // Use a lambda expression (Java 8+)
        java.util.function.BiPredicate<Integer, Integer> compareLE = (p, q) -> p <= q;
        boolean le = compareLE.test(a, b);
        // Use a static initializer block? Not here. Instead use a static method from another class
        boolean ge = Comparators.isGreaterOrEqual(a, b);
        boolean ne = (a != b);
    }
    
    static class Comparators {
        static boolean isGreaterOrEqual(int x, int y) {
            return x >= y;
        }
    }
}