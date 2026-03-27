// Equality test after a controlling equality test making it always false, not involving increment/overflow.
package scensct.var.pos;

public class PosCase3_Var1 {
    public static void main(String[] args) {
        final int value = 5;
        if (value != 10) { // [REPORTED LINE]
            // Outer condition is always true, but inner block is still unreachable due to inverted logic.
            // The inner equality test is guarded by a condition that is always false in practice.
            if (value == 10) { // [REPORTED LINE]
                boolean result = value == 10; // [REPORTED LINE]
                System.out.println(result);
            }
        }
    }
}