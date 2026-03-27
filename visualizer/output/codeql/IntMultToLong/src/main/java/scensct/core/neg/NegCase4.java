// Multiplication with compile-time constant operands that cannot overflow before implicit widening should not be flagged.
package scensct.core.neg;

public class NegCase4 {
    public static void main(String[] args) {
        final int c1 = 100;
        final int c2 = 200;
        long safeWidened = c1 * c2; // Scenario 4: Operands are compile-time constants, product 20000 fits in int, no overflow before widening to long
        System.out.println(safeWidened);
    }
}