// Multiplication with compile-time constant operands that cannot overflow before implicit widening should not be flagged.
package scensct.var.neg;

public class NegCase4_Var4 {
    public static void main(String[] args) {
        final int[] arr = {100, 200};
        long product = arr[0] * arr[1]; // [REPORTED LINE]
        System.out.println(product);
    }
}