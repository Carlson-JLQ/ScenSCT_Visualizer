// while loop with condition variable defined outside and no updates in body should be flagged as infinite loop
package scensct.core.pos;

public class PosCase1 {
    public static void main(String[] args) {
        int x = 5;
        // Condition variable x defined outside loop, never updated inside
        while (x > 0) { // [REPORTED LINE]
            // No update to x, loop condition constant
            System.out.println("stuck");
        }
    }
}