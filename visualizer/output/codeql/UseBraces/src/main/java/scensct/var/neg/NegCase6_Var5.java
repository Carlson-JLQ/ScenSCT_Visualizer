// Non-block body that is a jump/return/throw statement should not be flagged despite misleading indentation.
package scensct.var.neg;

public class NegCase6_Var5 {
    public static void main(String[] args) {
        int x = 5;
        outer:
        for (;;) {
            if (x > 10 || args.length == 0)
                break outer;
            else
                return;
            // Indented comment after
        }
    }
}