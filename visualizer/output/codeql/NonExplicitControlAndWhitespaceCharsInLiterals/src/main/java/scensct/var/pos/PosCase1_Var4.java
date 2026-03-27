// String literal containing DEL (U+007F) should be flagged as containing a non-explicit control character.
package scensct.var.pos;

public class PosCase1_Var4 {
    // Field with DEL string
    private static final String DEL_STRING = "textmore"; // [REPORTED LINE]
    
    public static void main(String[] args) {
        // DEL via static field
        String s = DEL_STRING;
        // Zero-width space via local variable reassignment
        String t = "text";
        t += "​more"; // [REPORTED LINE]
        // Numeric literal via arithmetic
        int n = 0176 + 1;
    }
}