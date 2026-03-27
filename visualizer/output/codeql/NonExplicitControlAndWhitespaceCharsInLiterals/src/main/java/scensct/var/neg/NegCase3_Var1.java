// Character literals should not be flagged as containing non-explicit control characters in string/numeric literals.
package scensct.var.neg;

public class NegCase3_Var1 {
    public static void main(String[] args) {
        // Character literals only, but with reordered declarations and different escape styles
        char tab = '\t';
        char omega = '\u03A9';
        char a = 'a';
        char nl = '\n';
        char zwsp = '\u200B';
        
        // Use a loop to print each character
        char[] chars = {a, nl, zwsp, tab, omega};
        for (char c : chars) {
            System.out.print(c);
        }
    }
}