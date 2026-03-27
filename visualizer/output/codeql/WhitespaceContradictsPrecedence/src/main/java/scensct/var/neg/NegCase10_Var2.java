// A binary expression of same operator kind directly nested inside another of same kind should not be flagged as nested binary operator with misleading whitespace.
package scensct.var.neg;

public class NegCase10_Var2 {
    public static void main(String[] args) {
        int a = 1, b = 2, c = 3;
        int temp = b + c;
        int result = a + temp; // Decomposed into temporaries, same operator nesting preserved
        System.out.println(result);
    }
}