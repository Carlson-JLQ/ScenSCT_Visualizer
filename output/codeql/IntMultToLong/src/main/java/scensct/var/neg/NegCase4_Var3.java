// Multiplication with compile-time constant operands that cannot overflow before implicit widening should not be flagged.
package scensct.var.neg;

public class NegCase4_Var3 {
    public static void main(String[] args) {
        final int x = 100;
        int y = 200;
        // y is effectively constant but not final; product still fits
        long val = x * y;
        System.out.println(val);
    }
}