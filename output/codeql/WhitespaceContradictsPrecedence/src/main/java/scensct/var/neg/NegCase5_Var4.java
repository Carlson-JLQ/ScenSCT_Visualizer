// A division expression as left operand of remainder, nested inside outer binary expression should not be flagged as nested binary operator with misleading whitespace.
package scensct.var.neg;

public class NegCase5_Var4 {
    public static void main(String[] args) {
        int x = 10, a = 20, b = 3, c = 2;
        int result;
        if (x > 0) { // trivial control flow
            result = x + a / b % c;
        } else {
            result = 0;
        }
        System.out.println(result);
    }
}