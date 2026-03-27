// A division expression as left operand of remainder, nested inside outer binary expression should not be flagged as nested binary operator with misleading whitespace.
package scensct.var.neg;

public class NegCase5_Var3 {
    private static int computeInner(int a, int b, int c) {
        return a / b % c; // move inner expression to helper
    }
    public static void main(String[] args) {
        int x = 10, a = 20, b = 3, c = 2;
        int result = x + computeInner(a, b, c);
        System.out.println(result);
    }
}