// Comparison with structurally identical binary expressions should be flagged as identical operands.
package scensct.var.pos;

public class PosCase3_Var5 {
    public static void main(String[] args) {
        int x = 5;
        int a = 2, b = 3;
        // Variant 5: Introduce a loop that doesn't modify operands, and use compound assignment
        for (int i = 0; i < 1; i++) {
            boolean b1 = (x + 1) > (x + 1); // [REPORTED LINE]
        }
        boolean b2 = (a * b) == (a * b); // [REPORTED LINE]
        boolean b3 = (x - 2) <= (x - 2); // [REPORTED LINE]
    }
}