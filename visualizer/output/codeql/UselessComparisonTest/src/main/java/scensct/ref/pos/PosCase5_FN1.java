// If condition with non-trivial constant analysis (overflow), not increment/overflow candidate type, then branch not a throw.
package scensct.ref.pos;

public class PosCase5_FN1 {
    public static void main(String[] args) {
        int max = Integer.MAX_VALUE;
        // Scenario 5: max + 1 < max is always true due to overflow (max+1 becomes Integer.MIN_VALUE)
        if (max + 1 < max) { // Always true
            // Then branch not a single throw
            System.out.println("Always printed due to overflow");
        }
    }
}