// A binary expression inner is directly nested inside outer, inner is not parenthesized, and whitespace around inner operator is odd number of spaces should not be flagged as nested binary operator with misleading whitespace.
package scensct.var.neg;

public class NegCase1_Var2 {
    public static void main(String[] args) {
        int[] vals = {1, 2, 3};
        int result = 0;
        for (int i = 0; i < vals.length; i++) {
            if (i == 0) result = vals[i];
            else if (i == 1) result = result + vals[i] * vals[2]; // odd spaces around '*'
        }
        System.out.println(result);
    }
}