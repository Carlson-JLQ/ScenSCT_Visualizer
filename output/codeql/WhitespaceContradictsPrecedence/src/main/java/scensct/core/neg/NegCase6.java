// A relational expression nested inside logical expression, which is nested inside outer binary expression should not be flagged as nested binary operator with misleading whitespace.
package scensct.core.neg;

public class NegCase6 {
    public static void main(String[] args) {
        int a = 1, b = 2, c = 3, d = 4;
        boolean x = true;
        boolean result = x || (a < b && c > d) == false; // inner '<' and '>' nested inside '&&', which is nested inside '||'
        System.out.println(result);
    }
}