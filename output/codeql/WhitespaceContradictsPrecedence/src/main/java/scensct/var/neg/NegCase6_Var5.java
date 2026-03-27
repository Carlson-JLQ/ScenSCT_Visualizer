// A relational expression nested inside logical expression, which is nested inside outer binary expression should not be flagged as nested binary operator with misleading whitespace.
package scensct.var.neg;

public class NegCase6_Var5 {
    public static void main(String[] args) {
        int a = 1, b = 2, c = 3, d = 4;
        boolean x = true;
        // Use an if-return control flow to compute the same boolean
        if (x) {
            System.out.println(true);
            return;
        }
        boolean temp = (a < b && c > d) == false;
        System.out.println(temp);
    }
}