// Multiplication where left operand is unknown/unbounded (method parameter), product may overflow int, then implicitly converted to long should be flagged.
package scensct.var.pos;

public class PosCase3_Var4 {
    public static void main(String[] args) {
        int val = fetchValue();
        long output = computeProduct(val, 100000); // Extract multiplication to helper
        System.out.println(output);
    }

    private static int fetchValue() {
        return 200000;
    }

    private static long computeProduct(int unknown, int constant) {
        return unknown * constant; // Multiplication in helper, still same pattern // [REPORTED LINE]
    }
}