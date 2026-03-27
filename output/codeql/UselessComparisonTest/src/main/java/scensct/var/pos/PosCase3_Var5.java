// Equality test after a controlling equality test making it always false, not involving increment/overflow.
package scensct.var.pos;

public class PosCase3_Var5 {
    public static void main(String[] args) {
        int x = 5;
        try {
            if (x == 10) { // [REPORTED LINE]
                boolean b = x == 10; // [REPORTED LINE]
                System.out.println(b);
            }
        } finally {
            // Finally block does not affect reachability of the inner equality test
            System.out.println("Finally executed");
        }
    }
}