// Comparison with identical string literals should be flagged as identical operands.
package scensct.var.pos;

public class PosCase1_Var3 {
    // Variant 3: Extract each comparison into a separate helper method.
    private static boolean compareInt() {
        return 5 == 5; // [REPORTED LINE]
    }
    private static boolean compareString() {
        return "abc" != "abc"; // [REPORTED LINE]
    }
    private static boolean compareDouble() {
        return 3.14 <= 3.14; // [REPORTED LINE]
    }
    public static void main(String[] args) {
        boolean b1 = compareInt();
        boolean b2 = compareString();
        boolean b3 = compareDouble();
    }
}