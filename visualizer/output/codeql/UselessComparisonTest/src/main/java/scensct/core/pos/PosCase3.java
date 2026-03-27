// Equality test after a controlling equality test making it always false, not involving increment/overflow.
package scensct.core.pos;

public class PosCase3 {
    public static void main(String[] args) {
        int x = 5;
        if (x == 10) { // [REPORTED LINE]
            // This block is unreachable because x is 5, but inside, the test is always false.
            // Scenario 3: x == 10 is always false here due to the outer if condition.
            boolean b = x == 10; // Always false // [REPORTED LINE]
            System.out.println(b);
        }
    }
}