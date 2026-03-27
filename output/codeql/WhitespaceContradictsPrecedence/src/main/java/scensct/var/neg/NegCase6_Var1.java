// A relational expression nested inside logical expression, which is nested inside outer binary expression should not be flagged as nested binary operator with misleading whitespace.
package scensct.var.neg;

public class NegCase6_Var1 {
    public static void main(String[] args) {
        int val1 = 1, val2 = 2, val3 = 3, val4 = 4;
        boolean flag = true;
        boolean outcome = flag || (val1 < val2 && val3 > val4) == false;
        System.out.println(outcome);
    }
}