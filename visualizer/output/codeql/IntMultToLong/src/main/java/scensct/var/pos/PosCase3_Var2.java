// Multiplication where left operand is unknown/unbounded (method parameter), product may overflow int, then implicitly converted to long should be flagged.
package scensct.var.pos;

public class PosCase3_Var2 {
    public static void main(String[] args) {
        int a = getUnknown();
        int b = 100000;
        long res;
        // Introduce temporary variable for product, still int multiplication
        int temp = a * b;
        res = temp; // Implicit widening to long after potential overflow
        System.out.println(res);
    }

    private static int getUnknown() {
        return 200000;
    }
}