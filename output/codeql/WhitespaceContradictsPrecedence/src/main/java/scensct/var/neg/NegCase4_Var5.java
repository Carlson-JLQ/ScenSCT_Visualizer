// An addition expression as left operand of subtraction, nested inside outer binary expression should not be flagged as nested binary operator with misleading whitespace.
package scensct.var.neg;

public class NegCase4_Var5 {
    public static void main(String[] args) {
        int x = 10, a = 2, b = 3, c = 4;
        // Split into steps preserving precedence
        int innerSum = a + b;
        int product = x * innerSum;
        int result = product - c;
        System.out.println(result);
    }
}