// Multiplication with compile-time constant operands that cannot overflow before implicit widening should not be flagged.
package scensct.var.neg;

public class NegCase4_Var5 {
    public static void main(String[] args) {
        final int c1 = 100;
        final int c2 = 200;
        long safeWidened;
        if (true) { // trivial always-true branch
            safeWidened = c1 * c2;
        } else {
            safeWidened = 0L;
        }
        System.out.println(safeWidened);
    }
}