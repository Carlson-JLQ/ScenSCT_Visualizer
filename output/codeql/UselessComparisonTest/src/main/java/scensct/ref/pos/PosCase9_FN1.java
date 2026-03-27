// Equality test inside loop after controlling equality, with overflow candidate, if condition then branch is a throw (not ConcurrentModificationException).
package scensct.ref.pos;

public class PosCase9_FN1 {
    public static void main(String[] args) {
        int val = 0;
        for (int i = 0; i < 3; i++) {
            if (val == 0) {
                // Inside block controlled by val==0, the overflow candidate equality test is always true
                // Scenario 9: Integer.MAX_VALUE + 1 != 0 is always true (overflow to Integer.MIN_VALUE, which != 0)
                if (Integer.MAX_VALUE + 1 != 0) { // Always true
                    // Single throw statement, not ConcurrentModificationException
                    throw new IllegalStateException("Overflow inequality");
                }
            }
            val++;
        }
    }
}