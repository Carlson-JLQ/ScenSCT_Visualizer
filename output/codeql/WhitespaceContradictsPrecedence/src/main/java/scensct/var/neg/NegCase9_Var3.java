// A binary expression inner is not a direct child operand of outer binary expression should not be flagged as nested binary operator with misleading whitespace.
package scensct.var.neg;

public class NegCase9_Var3 {
    public static void main(String[] args) {
        int a = 1, b = 2, c = 3, d = 4;
        int partial = computeSum(a, b); // '+' inside method
        int result = partial * (c + d); // '*' outer, inner '+' inside parentheses
        System.out.println(result);
    }

    private static int computeSum(int x, int y) {
        return x + y; // not nested under any other binary operator
    }
}