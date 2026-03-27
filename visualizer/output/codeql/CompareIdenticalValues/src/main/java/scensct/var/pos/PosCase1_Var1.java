// Comparison with identical string literals should be flagged as identical operands.
package scensct.var.pos;

public class PosCase1_Var1 {
    public static void main(String[] args) {
        // Variant 1: Introduce local variables to hold literals, then compare variables.
        int five = 5;
        boolean b1 = five == five; // [REPORTED LINE]
        String s = "abc";
        boolean b2 = s != s; // [REPORTED LINE]
        double pi = 3.14;
        boolean b3 = pi <= pi; // [REPORTED LINE]
    }
}