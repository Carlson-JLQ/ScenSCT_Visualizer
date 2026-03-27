// while loop with condition variable defined outside and no updates in body should be flagged as infinite loop
package scensct.var.pos;

public class PosCase1_Var5 {
    private static boolean check(int val) {
        return val > 0;
    }
    
    public static void main(String[] args) {
        int x = 5;
        // condition via helper method, x not updated
        while (check(x)) {
            System.out.println("stuck via method");
        }
    }
}