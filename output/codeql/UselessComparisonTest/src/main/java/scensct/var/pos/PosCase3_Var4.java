// Equality test after a controlling equality test making it always false, not involving increment/overflow.
package scensct.var.pos;

public class PosCase3_Var4 {
    public static void main(String[] args) {
        int x = 5;
        // Use a for loop with a false condition to create unreachable block
        for (int i = 0; x == 10; i++) { // [REPORTED LINE]
            boolean test = x == 10; // [REPORTED LINE]
            System.out.println(test);
        }
    }
}