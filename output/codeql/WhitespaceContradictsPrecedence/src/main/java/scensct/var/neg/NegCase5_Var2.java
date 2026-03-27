// A division expression as left operand of remainder, nested inside outer binary expression should not be flagged as nested binary operator with misleading whitespace.
package scensct.var.neg;

public class NegCase5_Var2 {
    public static void main(String[] args) {
        int x = 10, a = 20, b = 3, c = 2;
        int temp = a / b % c; // extract inner chain to temporary
        int result = x + temp;
        System.out.println(result);
    }
}