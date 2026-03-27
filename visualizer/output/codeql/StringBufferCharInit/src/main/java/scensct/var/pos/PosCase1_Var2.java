// Passing a char literal to StringBuffer constructor should be flagged as using capacity instead of character.
package scensct.var.pos;

public class PosCase1_Var2 {
    public static void main(String[] args) {
        // Variant 2: Wrap the call in a try-catch block (unrelated exception)
        try {
            StringBuffer buffer = new StringBuffer('a'); // [REPORTED LINE]
        } catch (RuntimeException e) {
            // Ignore
        }
    }
}