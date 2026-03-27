// A binary expression inner is directly nested inside outer, inner is not parenthesized, and whitespace around inner operator is odd number of spaces should not be flagged as nested binary operator with misleading whitespace.
package scensct.var.neg;

public class NegCase1_Var4 {
    public static void main(String[] args) {
        double d1 = 1.5, d2 = 2.0, d3 = 3.0;
        double result = d1 + d2 * d3; // '*' still higher precedence than '+', odd spaces
        System.out.println(result);
    }
}