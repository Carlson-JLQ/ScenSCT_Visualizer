// Comparison with structurally identical binary expressions should be flagged as identical operands.
package scensct.var.pos;

public class PosCase3_Var2 {
    public static void main(String[] args) {
        int x = 5;
        int a = 2, b = 3;
        // Variant 2: Wrap in if-else that doesn't affect values, and reorder declarations
        if (x > 0) {
            boolean b2 = (a * b) == (a * b); // [REPORTED LINE]
        } else {
            // dead branch
            boolean dummy = false;
        }
        boolean b1 = (x + 1) > (x + 1); // [REPORTED LINE]
        boolean b3 = (x - 2) <= (x - 2); // [REPORTED LINE]
    }
}