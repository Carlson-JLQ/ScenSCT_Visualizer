// Multiplication where left operand is unknown/unbounded (method parameter), product may overflow int, then implicitly converted to long should be flagged.
package scensct.var.pos;

public class PosCase3_Var3 {
    public static void main(String[] args) {
        int x = getUnknown();
        int y = 100000;
        long result;
        // Wrap in try-catch, but multiplication remains reachable
        try {
            result = x * y; // [REPORTED LINE]
        } finally {
            // No effect on overflow
        }
        System.out.println(result);
    }

    private static int getUnknown() {
        return 200000;
    }
}