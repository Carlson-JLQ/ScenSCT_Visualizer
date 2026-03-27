// A relational expression nested inside logical expression, which is nested inside outer binary expression should not be flagged as nested binary operator with misleading whitespace.
package scensct.var.neg;

public class NegCase6_Var4 {
    private static boolean compare(int a, int b, int c, int d) {
        return a < b && c > d;
    }
    
    public static void main(String[] args) {
        int a = 1, b = 2, c = 3, d = 4;
        boolean x = true;
        // Move the inner && expression to a helper method
        boolean result = x || compare(a, b, c, d) == false;
        System.out.println(result);
    }
}