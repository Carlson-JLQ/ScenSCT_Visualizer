// Multiplication with compile-time constant operands that cannot overflow before implicit widening should not be flagged.
package scensct.var.neg;

public class NegCase4_Var1 {
    public static void main(String[] args) {
        final int a = 50 * 2; // 100
        final int b = 400 / 2; // 200
        long result = a * b;
        System.out.println(result);
    }
}