// String literal containing DEL (U+007F) should be flagged as containing a non-explicit control character.
package scensct.var.pos;

public class PosCase1_Var5 {
    public static void main(String[] args) {
        // Variant 5: DEL in a string with other escapes, using octal escape for DEL
        String s = "text\177more";
        // Zero-width space as Unicode escape in a concatenated loop
        String t = "text";
        for (int i = 0; i < 1; i++) {
            t += "\u200B" + "more";
        }
        // Numeric literal via method parameter
        int n = processDel(0177);
    }
    
    private static int processDel(int val) {
        return val;
    }
}