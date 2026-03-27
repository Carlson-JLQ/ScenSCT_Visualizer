// Comparing different integer literals should not be flagged as identical operand comparison.
package scensct.var.neg;

public class NegCase1_Var4 {
    public static void main(String[] args) {
        // Use array elements with distinct values
        int[] arr = {5, 10};
        int a = arr[0];
        int b = arr[1];
        boolean result = (arr[0] == arr[1]);
        // Use System.identityHashCode? No, not for ints. Instead use bitwise operations
        boolean result2 = ((a & 0xFF) == (b & 0xFF));
        // Compare within an anonymous inner class (if allowed, but keep simple)
        Runnable r = new Runnable() {
            @Override
            public void run() {
                // Comparisons inside are not directly in main, but still in scope
                boolean lt = (a < b);
            }
        };
        // Use a do-while loop
        boolean gt = false;
        do {
            gt = (b > a);
        } while (false);
        // Use a helper object with fields
        Holder h1 = new Holder(a);
        Holder h2 = new Holder(b);
        boolean le = (h1.value <= h2.value);
        boolean ge = (h1.value >= h2.value);
        boolean ne = (h1.value != h2.value);
    }
    
    static class Holder {
        int value;
        Holder(int v) { this.value = v; }
    }
}