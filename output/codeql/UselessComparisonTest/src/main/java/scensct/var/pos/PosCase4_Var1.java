// If condition inside loop with constant false comparison and increment compared to itself, then branch not a throw.
package scensct.var.pos;

public class PosCase4_Var1 {
    public static void main(String[] args) {
        // Variant 1: for-loop, post-decrement with offset, renamed variable
        for (int j = 0; j < 10; j++) {
            int temp = j - 1;
            if (temp > j) { // Always false (temp = j-1 < j)
                System.out.println("Unreachable");
            }
        }
    }
}