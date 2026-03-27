// If condition inside loop with constant false comparison and increment compared to itself, then branch not a throw.
package scensct.var.pos;

public class PosCase4_Var2 {
    public static void main(String[] args) {
        // Variant 2: do-while, decrement in separate statement, use <=
        int k = 0;
        do {
            k--;
            if (k <= k + 1) { // Always true? Wait, k <= k+1 is always true, but we need always false.
                // Actually we need always false. Let's adjust: k >= k+1 is always false.
                if (k >= k + 1) { // Always false
                    System.out.println("Unreachable");
                }
            }
            k += 2; // adjust to keep loop finite
        } while (k < 10);
    }
}