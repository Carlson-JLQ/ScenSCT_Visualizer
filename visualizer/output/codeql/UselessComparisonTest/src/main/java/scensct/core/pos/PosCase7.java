// If condition with non-trivial constant analysis (range), not increment/overflow type, then branch is a throw (not ConcurrentModificationException).
package scensct.core.pos;

public class PosCase7 {
    public static void main(String[] args) {
        int y = 100;
        // Scenario 7: y > 200 is always false given y=100 (range analysis)
        if (y > 200) { // Always false // [REPORTED LINE]
            // Single throw statement, not ConcurrentModificationException
            throw new IllegalArgumentException("y too large");
        }
    }
}