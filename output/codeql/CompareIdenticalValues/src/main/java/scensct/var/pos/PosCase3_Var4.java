// Comparison with structurally identical binary expressions should be flagged as identical operands.
package scensct.var.pos;

public class PosCase3_Var4 {
    public static void main(String[] args) {
        // Variant 4: Use array elements to hold values, same expressions
        int[] vals = {5, 2, 3};
        int x = vals[0];
        int a = vals[1], b = vals[2];
        boolean b1 = (x + 1) > (x + 1); // [REPORTED LINE]
        boolean b2 = (a * b) == (a * b); // [REPORTED LINE]
        boolean b3 = (x - 2) <= (x - 2); // [REPORTED LINE]
    }
}