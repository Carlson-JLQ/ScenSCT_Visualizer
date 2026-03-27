// Character literals should not be flagged as containing non-explicit control characters in string/numeric literals.
package scensct.var.neg;

public class NegCase3_Var2 {
    // Extract character definitions to static fields
    private static final char LETTER = 'a';
    private static final char NEWLINE = '\n';
    private static final char ZERO_WIDTH_SPACE = '\u200B';
    private static final char TAB = '\t';
    private static final char UNICODE_SYMBOL = '\u03A9';
    
    public static void main(String[] args) {
        // Pass characters to a helper method for printing
        printChar(LETTER);
        printChar(NEWLINE);
        printChar(ZERO_WIDTH_SPACE);
        printChar(TAB);
        printChar(UNICODE_SYMBOL);
    }
    
    private static void printChar(char c) {
        System.out.print(c);
    }
}