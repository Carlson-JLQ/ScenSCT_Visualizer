// Character literals should not be flagged as containing non-explicit control characters in string/numeric literals.
package scensct.var.neg;

public class NegCase3_Var4 {
    public static void main(String[] args) {
        // Introduce temporary variables and control flow that doesn't affect literals
        char first = 'a';
        char second = first == 'a' ? '\n' : 'x';
        char third = '\u200B';
        char fourth = (args.length > 0) ? '\t' : '\t'; // always tab
        char fifth = '\u03A9';
        
        // Print with explicit casting (no effect, but adds noise)
        System.out.print((char) first);
        System.out.print((char) second);
        System.out.print((char) third);
        System.out.print((char) fourth);
        System.out.print((char) fifth);
    }
}