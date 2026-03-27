// A multiplication expression as left operand of division, nested inside outer binary expression should not be flagged as nested binary operator with misleading whitespace.
package scensct.var.neg;

public class NegCase3_Var5 {
    public static void main(String[] args) {
        int x = 10;
        int a = 2;
        int b = 3;
        int c = 4;
        // use parentheses to make grouping explicit, but whitespace unchanged
        int result = x + (a * b) / c; // parentheses added, but whitespace pattern a * b / c still present
        System.out.println(result);
    }
}