// Multiplication where left operand is unknown/unbounded (method parameter), product may overflow int, then implicitly converted to long should be flagged.
package scensct.core.pos;

public class PosCase3 {
    public static void main(String[] args) {
        int x = getUnknown(); // Simulate unknown value
        int y = 100000;
        long result = x * y; // Left operand x is unknown/unbounded, product may overflow int // [REPORTED LINE]
        System.out.println(result);
    }

    // Helper to simulate unknown/unbounded int value (e.g., from parameter)
    private static int getUnknown() {
        return 200000; // Concrete value for compilation, but checker treats as unknown
    }
}