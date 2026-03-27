// String literal containing DEL (U+007F) should be flagged as containing a non-explicit control character.
package scensct.var.pos;

public class PosCase1_Var2 {
    // Helper method returning string with DEL
    private static String getDelString() {
        return "textmore"; // [REPORTED LINE]
    }
    
    public static void main(String[] args) {
        // DEL via method call
        String s = getDelString();
        // Zero-width space inline
        String t = "text​more"; // [REPORTED LINE]
        // Numeric literal via cast
        int n = (int) 0177L;
    }
}