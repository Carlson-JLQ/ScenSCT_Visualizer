// while loop with condition using final field and variable defined outside should be flagged as infinite loop
package scensct.var.pos;

public class PosCase2_Var4 {
    private static final int LIMIT = 10;
    public static void main(String[] args) {
        int y = 3;
        // Extract condition evaluation to a helper method
        while (conditionHolds(y)) {
            System.out.println("stuck");
        }
    }
    private static boolean conditionHolds(int val) {
        return val < LIMIT;
    }
}