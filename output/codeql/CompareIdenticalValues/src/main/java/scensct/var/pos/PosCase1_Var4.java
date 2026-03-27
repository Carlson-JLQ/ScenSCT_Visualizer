// Comparison with identical string literals should be flagged as identical operands.
package scensct.var.pos;

public class PosCase1_Var4 {
    public static void main(String[] args) {
        // Variant 4: Use a loop to execute comparisons multiple times (once).
        for (int i = 0; i < 1; i++) {
            boolean b1 = 5 == 5; // [REPORTED LINE]
            boolean b2 = "abc" != "abc"; // [REPORTED LINE]
            boolean b3 = 3.14 <= 3.14; // [REPORTED LINE]
        }
    }
}