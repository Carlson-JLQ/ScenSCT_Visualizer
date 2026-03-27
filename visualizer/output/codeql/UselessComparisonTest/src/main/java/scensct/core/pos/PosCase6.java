// If condition inside loop with constant false comparison and overflow candidate, then branch is a throw (not ConcurrentModificationException).
package scensct.core.pos;

public class PosCase6 {
    public static void main(String[] args) {
        for (int j = 0; j < 3; j++) {
            // Scenario 6: Integer.MAX_VALUE + 1 < 0 is always true (overflow to Integer.MIN_VALUE, which is < 0)
            int overflow = Integer.MAX_VALUE + 1;
            if (overflow < 0) { // Always true
                // Single throw statement, not ConcurrentModificationException
                throw new RuntimeException("Overflow detected");
            }
        }
    }
}