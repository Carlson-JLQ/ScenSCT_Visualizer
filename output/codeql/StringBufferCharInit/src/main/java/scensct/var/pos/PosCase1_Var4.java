// Passing a char literal to StringBuffer constructor should be flagged as using capacity instead of character.
package scensct.var.pos;

public class PosCase1_Var4 {
    public static void main(String[] args) {
        // Variant 4: Use StringBuilder (same rule applies)
        StringBuilder builder = new StringBuilder('a'); // [REPORTED LINE]
    }
}