// A multiplication expression as left operand of division, nested inside outer binary expression should not be flagged as nested binary operator with misleading whitespace.
package scensct.var.neg;

public class NegCase3_Var2 {
    public static void main(String[] args) {
        int x = 10;
        int a = 2, b = 3, c = 4;
        int temp = a * b; // inner multiplication extracted
        int result = x + temp / c; // division's left operand is temp, preserving precedence
        System.out.println(result);
    }
}