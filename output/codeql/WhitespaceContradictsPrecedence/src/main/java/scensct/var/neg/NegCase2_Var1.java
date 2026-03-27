// A binary equality expression directly nested inside another binary equality expression should not be flagged as nested binary operator with misleading whitespace.
package scensct.var.neg;

public class NegCase2_Var1 {
    public static void main(String[] args) {
        boolean x = true, y = false, z = true;
        boolean innerEq = x == y;
        boolean result = innerEq == z;
        System.out.println(result);
    }
}