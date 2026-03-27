// A binary expression of same operator kind directly nested inside another of same kind should not be flagged as nested binary operator with misleading whitespace.
package scensct.var.neg;

public class NegCase10_Var5 {
    public static void main(String[] args) {
        int a = 1, b = 2, c = 3;
        int result = (a + b) + c; // Parenthesized left-associative grouping, same operators
        System.out.println(result);
    }
}