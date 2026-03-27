// An addition expression as left operand of subtraction, nested inside outer binary expression should not be flagged as nested binary operator with misleading whitespace.
package scensct.var.neg;

public class NegCase4_Var1 {
    public static void main(String[] args) {
        int x = 10, a = 2, b = 3, c = 4;
        int temp = a + b; // Extract inner addition
        int result = x * temp - c; // Maintain same precedence: * then + (in temp) then -
        System.out.println(result);
    }
}