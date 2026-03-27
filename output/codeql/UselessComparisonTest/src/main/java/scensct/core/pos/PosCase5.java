// If condition with non-trivial constant analysis (overflow), not increment/overflow candidate type, then branch not a throw.
package scensct.core.pos;

public class PosCase5 {
    public static void main(String[] args) {
        int max = Integer.MAX_VALUE;
        // Scenario 5: max + 1 < max is always true due to overflow (max+1 becomes Integer.MIN_VALUE)
        int overflow = max + 1;
        if (overflow < max) { // Always true
            // Then branch not a single throw
            System.out.println("Always printed due to overflow");
        }
    }
}