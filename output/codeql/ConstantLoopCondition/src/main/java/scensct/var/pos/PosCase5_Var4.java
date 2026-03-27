// while true loop with if condition using variable defined outside controlling all exits should be flagged as infinite loop
package scensct.var.pos;

public class PosCase5_Var4 {
    public static void main(String[] args) {
        int counter = 0;
        // Restructure with labeled break
        outer: while (true) {
            if (counter == 1) { // [REPORTED LINE]
                break outer;
            }
            System.out.println("stuck");
            // Unreachable continue
            continue;
        }
    }
}