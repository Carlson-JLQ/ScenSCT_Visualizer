// An addition expression as left operand of subtraction, nested inside outer binary expression should not be flagged as nested binary operator with misleading whitespace.
package scensct.var.neg;

public class NegCase4_Var4 {
    public static void main(String[] args) {
        int[] vals = {10, 2, 3, 4};
        int x = vals[0], a = vals[1], b = vals[2], c = vals[3];
        int result = x * a + b - c; // Same expression with variables from array
        System.out.println(result);
    }
}