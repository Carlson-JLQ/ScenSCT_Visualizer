// Comparison with identical string literals should be flagged as identical operands.
package scensct.var.pos;

public class PosCase1_Var5 {
    public static void main(String[] args) {
        // Variant 5: Use try-catch-finally to structure the comparisons.
        try {
            boolean b1 = 5 == 5; // [REPORTED LINE]
            throw new RuntimeException(); // force catch block
        } catch (RuntimeException e) {
            boolean b2 = "abc" != "abc"; // [REPORTED LINE]
        } finally {
            boolean b3 = 3.14 <= 3.14; // [REPORTED LINE]
        }
    }
}