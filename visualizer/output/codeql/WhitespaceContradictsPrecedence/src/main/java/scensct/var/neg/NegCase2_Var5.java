// A binary equality expression directly nested inside another binary equality expression should not be flagged as nested binary operator with misleading whitespace.
package scensct.var.neg;

public class NegCase2_Var5 {
    public static void main(String[] args) {
        boolean first = true;
        boolean second = false;
        boolean third = true;
        boolean result = (first == second) == third;
        System.out.println(result);
    }
}