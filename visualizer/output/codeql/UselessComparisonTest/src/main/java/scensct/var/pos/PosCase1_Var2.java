// Binary comparison inside loop with constant operands and increment compared to itself should be flagged as always true.
package scensct.var.pos;

public class PosCase1_Var2 {
    public static void main(String[] args) {
        // Variant 2: Introduce temporary variable and do-while loop
        int idx = 0;
        do {
            int afterIncrement = idx + 1;
            boolean result = afterIncrement > idx; // Always true
            System.out.println(result);
            idx++;
        } while (idx < 10);
    }
}