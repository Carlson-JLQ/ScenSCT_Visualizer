// A binary equality expression directly nested inside another binary equality expression should not be flagged as nested binary operator with misleading whitespace.
package scensct.var.neg;

public class NegCase2_Var3 {
    private static boolean checkEqualities(boolean a, boolean b, boolean c) {
        return a == b == c;
    }
    
    public static void main(String[] args) {
        boolean a = true, b = false, c = true;
        boolean result = checkEqualities(a, b, c);
        System.out.println(result);
    }
}