// An addition expression as left operand of subtraction, nested inside outer binary expression should not be flagged as nested binary operator with misleading whitespace.
package scensct.var.neg;

public class NegCase4_Var3 {
    public static void main(String[] args) {
        int x = 10, a = 2, b = 3, c = 4;
        int result = x * a + b - c; // Original expression
        if (result > 0) { // Add irrelevant control flow
            System.out.println(result);
        } else {
            System.out.println(0);
        }
    }
}