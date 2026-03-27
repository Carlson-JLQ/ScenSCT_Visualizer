// Using arithmetic addition operator should not be flagged as identical operand comparison.
package scensct.var.neg;

public class NegCase2_Var3 {
    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        // Variant 3: Introduce temporary variables and split expressions
        int temp1 = m;
        int temp2 = n;
        int sum = temp1 + temp2;
        int diff = temp1 - temp2;
        int prod = temp1 * temp2;
        int quot = temp1 / temp2;
        int and = temp1 & temp2;
        int or = temp1 | temp2;
        int xor = temp1 ^ temp2;
        m = temp2; // Assignment via temporary
    }
}