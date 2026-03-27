// Comparison with structurally identical binary expressions should be flagged as identical operands.
package scensct.var.pos;

public class PosCase3_Var1 {
    public static void main(String[] args) {
        int x = 5;
        int a = 2, b = 3;
        // Variant 1: Use temporary variables to alias expressions
        int temp1 = x + 1;
        int temp2 = a * b;
        int temp3 = x - 2;
        boolean b1 = temp1 > temp1; // [REPORTED LINE]
        boolean b2 = temp2 == temp2; // [REPORTED LINE]
        boolean b3 = temp3 <= temp3; // [REPORTED LINE]
    }
}