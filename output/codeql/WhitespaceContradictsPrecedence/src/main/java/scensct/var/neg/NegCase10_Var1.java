// A binary expression of same operator kind directly nested inside another of same kind should not be flagged as nested binary operator with misleading whitespace.
package scensct.var.neg;

public class NegCase10_Var1 {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 3;
        int result = a + (b + c); // Same operators, parentheses added but not misleading
        System.out.println(result);
    }
}