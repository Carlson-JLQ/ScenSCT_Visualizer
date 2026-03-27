// Character literals should not be flagged as containing non-explicit control characters in string/numeric literals.
package scensct.core.neg;

public class NegCase3 {
    public static void main(String[] args) {
        // Character literals only (no string or numeric literals)
        char letter = 'a';
        char newline = '\n';
        char zeroWidthSpace = '\u200B'; // Zero-width space in char literal
        char tab = '\t';
        char unicode = '\u03A9'; // Greek capital letter Omega
        System.out.print(letter);
        System.out.print(newline);
        System.out.print(zeroWidthSpace);
        System.out.print(tab);
        System.out.print(unicode);
    }
}