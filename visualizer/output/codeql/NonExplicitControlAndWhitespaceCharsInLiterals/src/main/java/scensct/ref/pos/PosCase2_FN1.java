// String literal containing non-printable control character (BEL, U+0007) should be flagged as containing a non-printable control character.
package scensct.ref.pos;

public class PosCase2_FN1 {
    public static void main(String[] args) {
        // BEL character (U+0007) in string literal - control character < 32, not standard whitespace
        String s = "text\007more";
        // Numeric literal with control character (vertical tab, octal 13) - triggers scenario 2
        int n = 013;
    }
}