// Passing a char literal to StringBuffer constructor should be flagged as using capacity instead of character.
package scensct.var.pos;

public class PosCase1_Var5 {
    public static void main(String[] args) {
        // Variant 5: Add irrelevant control flow (if-else that always takes the same path)
        boolean flag = true;
        if (flag) {
            StringBuffer buffer = new StringBuffer('a'); // [REPORTED LINE]
        } else {
            // Dead code
            System.out.println("unreachable");
        }
    }
}