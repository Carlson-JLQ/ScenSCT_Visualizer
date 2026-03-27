// Comparison with structurally identical binary expressions should be flagged as identical operands.
package scensct.var.pos;

public class PosCase3_Var3 {
    // Variant 3: Extract identical expressions to a helper method
    private static int addOne(int n) {
        return n + 1;
    }
    private static int multiply(int m, int n) {
        return m * n;
    }
    private static int subtractTwo(int n) {
        return n - 2;
    }
    public static void main(String[] args) {
        int x = 5;
        int a = 2, b = 3;
        boolean b1 = addOne(x) > addOne(x);
        boolean b2 = multiply(a, b) == multiply(a, b);
        boolean b3 = subtractTwo(x) <= subtractTwo(x);
    }
}