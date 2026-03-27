// A multiplication expression as left operand of division, nested inside outer binary expression should not be flagged as nested binary operator with misleading whitespace.
package scensct.var.neg;

public class NegCase3_Var3 {
    public static void main(String[] args) {
        int base = 10;
        int m1 = 2, m2 = 3, divisor = 4;
        int product = multiply(m1, m2); // helper for multiplication
        int result = base + product / divisor; // same nesting via method call
        System.out.println(result);
    }

    private static int multiply(int i, int j) {
        return i * j;
    }
}