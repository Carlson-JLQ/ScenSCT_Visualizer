// A binary expression of same operator kind directly nested inside another of same kind should not be flagged as nested binary operator with misleading whitespace.
package scensct.var.neg;

public class NegCase10_Var4 {
    public static void main(String[] args) {
        int a = 1, b = 2, c = 3;
        int result = a;
        result += b; // Using compound assignment, but final expression is a + b + c
        result += c;
        System.out.println(result);
    }
}