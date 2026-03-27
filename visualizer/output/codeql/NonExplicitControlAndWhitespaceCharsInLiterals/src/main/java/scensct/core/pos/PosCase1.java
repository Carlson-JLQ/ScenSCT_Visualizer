// String literal containing DEL (U+007F) should be flagged as containing a non-explicit control character.
package scensct.core.pos;

public class PosCase1 {
    public static void main(String[] args) {
        // DEL character (U+007F) in string literal
        String s = "textmore"; // [REPORTED LINE]
        // Zero-width space (U+200B) in string literal
        String t = "text​more"; // [REPORTED LINE]
        // Numeric literal with DEL (octal 177) - triggers scenario 1
        int n = 0177;
    }
}