// A relational expression nested inside logical expression, which is nested inside outer binary expression should not be flagged as nested binary operator with misleading whitespace.
package scensct.var.neg;

public class NegCase6_Var3 {
    public static void main(String[] args) {
        int a = 1, b = 2, c = 3, d = 4;
        boolean x = true;
        // Extract inner relational comparison to a temporary variable
        boolean innerRel = a < b && c > d;
        boolean result = x || innerRel == false;
        System.out.println(result);
    }
}