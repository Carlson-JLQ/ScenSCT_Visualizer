// A relational expression nested inside logical expression, which is nested inside outer binary expression should not be flagged as nested binary operator with misleading whitespace.
package scensct.var.neg;

public class NegCase6_Var2 {
    public static void main(String[] args) {
        int p = 1, q = 2, r = 3, s = 4;
        boolean t = true;
        // Using logical NOT instead of == false
        boolean res = t || !(p < q && r > s);
        System.out.println(res);
    }
}