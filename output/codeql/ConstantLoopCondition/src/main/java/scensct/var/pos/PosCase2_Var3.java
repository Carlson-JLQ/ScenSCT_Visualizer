// while loop with condition using final field and variable defined outside should be flagged as infinite loop
package scensct.var.pos;

public class PosCase2_Var3 {
    private static final int LIMIT = 10;
    public static void main(String[] args) {
        int y = 3;
        // Restructure control flow with an if that always enters the loop
        if (y < LIMIT) {
            do {
                System.out.println("stuck");
            } while (y < LIMIT); // [REPORTED LINE]
        }
    }
}