// A binary expression of same operator kind directly nested inside another of same kind should not be flagged as nested binary operator with misleading whitespace.
package scensct.var.neg;

public class NegCase10_Var3 {
    public static void main(String[] args) {
        int a = 1, b = 2, c = 3;
        int result = computeSum(a, b, c); // Extracted to helper method
        System.out.println(result);
    }

    private static int computeSum(int x, int y, int z) {
        return x + y + z; // Inner and outer '+' remain same kind
    }
}