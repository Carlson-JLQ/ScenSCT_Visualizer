// A binary equality expression directly nested inside another binary equality expression should not be flagged as nested binary operator with misleading whitespace.
package scensct.var.neg;

public class NegCase2_Var2 {
    public static void main(String[] args) {
        boolean p = true, q = false, r = true;
        boolean result = (p == q ? true : false) == r;
        System.out.println(result);
    }
}