// while loop with condition using final field and variable defined outside should be flagged as infinite loop
package scensct.core.pos;

public class PosCase2 {
    private static final int LIMIT = 10;
    public static void main(String[] args) {
        int y = 3;
        // Condition uses final field LIMIT and variable y defined outside
        while (y < LIMIT) { // [REPORTED LINE]
            // No update to y, condition constant
            System.out.println("stuck");
        }
    }
}