// A binary equality expression directly nested inside another binary equality expression should not be flagged as nested binary operator with misleading whitespace.
package scensct.var.neg;

public class NegCase2_Var4 {
    public static void main(String[] args) {
        boolean[] vals = {true, false, true};
        boolean current = vals[0] == vals[1];
        boolean result = current == vals[2];
        System.out.println(result);
    }
}