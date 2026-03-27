// An addition expression as left operand of subtraction, nested inside outer binary expression should not be flagged as nested binary operator with misleading whitespace.
package scensct.var.neg;

public class NegCase4_Var2 {
    public static void main(String[] args) {
        int x = 10, a = 2, b = 3, c = 4;
        int result = compute(x, a, b, c);
        System.out.println(result);
    }

    private static int compute(int x, int a, int b, int c) {
        return x * (a + b) - c; // Explicit parentheses to clarify, but precedence unchanged
    }
}