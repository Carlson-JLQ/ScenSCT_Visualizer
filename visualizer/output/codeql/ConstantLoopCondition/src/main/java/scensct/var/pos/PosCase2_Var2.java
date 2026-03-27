// while loop with condition using final field and variable defined outside should be flagged as infinite loop
package scensct.var.pos;

public class PosCase2_Var2 {
    private static final int LIMIT = 10;
    public static void main(String[] args) {
        int y = 3;
        // Introduce an alias for y via a final local variable
        final int aliasY = y;
        while (aliasY < LIMIT) { // [REPORTED LINE]
            System.out.println("stuck");
            // No update to aliasY
        }
    }
}