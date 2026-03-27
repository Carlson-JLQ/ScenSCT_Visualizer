// while loop with condition using final field and variable defined outside should be flagged as infinite loop
package scensct.var.pos;

public class PosCase2_Var5 {
    private static final int LIMIT = 10;
    public static void main(String[] args) {
        int y = 3;
        // Use a for loop with empty update, condition constant
        for (; y < LIMIT; ) { // [REPORTED LINE]
            System.out.println("stuck");
        }
    }
}