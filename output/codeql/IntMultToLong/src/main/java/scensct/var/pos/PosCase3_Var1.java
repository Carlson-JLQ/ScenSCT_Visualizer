// Multiplication where left operand is unknown/unbounded (method parameter), product may overflow int, then implicitly converted to long should be flagged.
package scensct.var.pos;

public class PosCase3_Var1 {
    public static void main(String[] args) {
        int unknown = getUnknown();
        int multiplier = 100000;
        long product = unknown * multiplier; // Renamed variables, same pattern // [REPORTED LINE]
        System.out.println(product);
    }

    private static int getUnknown() {
        return 200000;
    }
}