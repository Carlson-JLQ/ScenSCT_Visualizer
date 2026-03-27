// String literal containing non-printable control character (BEL, U+0007) should be flagged as containing a non-printable control character.
package scensct.core.pos;

public class PosCase2 {
    public static void main(String[] args) {
        // BEL character (U+0007) in string literal - control character < 32, not standard whitespace
        String s = "text\u0007more";
    }
}