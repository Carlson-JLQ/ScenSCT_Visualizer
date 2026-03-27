// Comparison with identical string literals should be flagged as identical operands.
package scensct.var.pos;

public class PosCase1_Var2 {
    public static void main(String[] args) {
        // Variant 2: Embed comparisons in a simple if-else block, but always take the true branch.
        if (args.length >= 0) { // always true
            boolean b1 = 5 == 5; // [REPORTED LINE]
            boolean b2 = "abc" != "abc"; // [REPORTED LINE]
            boolean b3 = 3.14 <= 3.14; // [REPORTED LINE]
        }
    }
}