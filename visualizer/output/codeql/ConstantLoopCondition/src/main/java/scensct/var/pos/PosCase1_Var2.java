// while loop with condition variable defined outside and no updates in body should be flagged as infinite loop
package scensct.var.pos;

public class PosCase1_Var2 {
    public static void main(String[] args) {
        int x = 1;
        int y = x; // alias
        // Condition uses alias, still never updated
        while (y > 0) { // [REPORTED LINE]
            System.out.println("stuck with alias");
        }
    }
}