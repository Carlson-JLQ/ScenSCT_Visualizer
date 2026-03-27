// A binary expression inner directly nested inside outer, inner not parenthesized, and no whitespace around inner operator should not be flagged as nested binary operator with misleading whitespace.
package scensct.var.neg;

public class NegCase7_Var3 {
    public static void main(String[] args) {
        int n1 = 1, n2 = 2, n3 = 3;
        int temp = n2 * n3;
        int answer = n1 + temp;
        System.out.println(answer);
    }
}