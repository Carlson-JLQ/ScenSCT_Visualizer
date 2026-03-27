// Binary comparison inside loop with overflow candidate compared to 0 should be flagged as always false.
package scensct.core.pos;

public class PosCase2 {
    public static void main(String[] args) {
        for (int j = 0; j < 5; j++) {
            // Scenario 2: Integer.MAX_VALUE + 1 <= 0 is always true due to overflow (becomes Integer.MIN_VALUE, which is <= 0)
            int overflow = Integer.MAX_VALUE + 1;
            boolean b = overflow <= 0; // Always true
            System.out.println(b);
        }
    }
}