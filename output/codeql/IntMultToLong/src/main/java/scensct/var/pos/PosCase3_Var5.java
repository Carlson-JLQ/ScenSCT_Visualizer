// Multiplication where left operand is unknown/unbounded (method parameter), product may overflow int, then implicitly converted to long should be flagged.
package scensct.var.pos;

public class PosCase3_Var5 {
    public static void main(String[] args) {
        int x = getUnknown();
        // Use expression with same constant value but different representation
        int y = 50 * 2000; // Evaluates to 100000 at compile time
        long result = x * y; // Same overflow risk // [REPORTED LINE]
        System.out.println(result);
    }

    private static int getUnknown() {
        return 200000;
    }
}