// A binary expression inner directly nested inside outer, inner not parenthesized, whitespace around inner operator is even, and no whitespace around outer operator should not be flagged as nested binary operator with misleading whitespace.
package scensct.var.neg;

public class NegCase8_Var3 {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 3;
        int res;
        if (args.length > 0) {
            res = a+b*c; // Core expression inside a conditional branch, still reachable
        } else {
            res = 0;
        }
        System.out.println(res);
    }
}