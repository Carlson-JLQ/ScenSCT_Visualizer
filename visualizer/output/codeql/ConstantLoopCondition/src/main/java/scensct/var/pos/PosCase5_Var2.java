// while true loop with if condition using variable defined outside controlling all exits should be flagged as infinite loop
package scensct.var.pos;

public class PosCase5_Var2 {
    public static void main(String[] args) {
        int x = 0;
        boolean flag = (x == 1); // constant false
        while (true) {
            // Exit condition computed outside loop
            if (flag) { // [REPORTED LINE]
                return;
            }
            System.out.println("stuck");
            // No modification of x or flag
        }
    }
}