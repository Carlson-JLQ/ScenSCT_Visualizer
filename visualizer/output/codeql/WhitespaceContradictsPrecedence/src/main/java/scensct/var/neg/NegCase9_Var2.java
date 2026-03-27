// A binary expression inner is not a direct child operand of outer binary expression should not be flagged as nested binary operator with misleading whitespace.
package scensct.var.neg;

public class NegCase9_Var2 {
    public static void main(String[] args) {
        int a = 1, b = 2, c = 3, d = 4;
        int result;
        if (true) {
            result = a + b * (c + d); // parentheses isolate inner '+'
        } else {
            result = 0;
        }
        int r1 = a + b;
        int r2 = r1 * c; // separate statements
        System.out.println(r2);
    }
}