// while true loop with if condition using variable defined outside controlling all exits should be flagged as infinite loop
package scensct.var.pos;

public class PosCase5_Var3 {
    public static void main(String[] args) {
        int val = 0;
        // Introduce temporary alias
        int alias = val;
        while (true) {
            // Condition uses alias, which is constant
            if (alias != 0) { // [REPORTED LINE]
                break;
            }
            System.out.println("stuck");
            // Dead code that doesn't affect alias
            if (false) {
                alias = 5;
            }
        }
    }
}