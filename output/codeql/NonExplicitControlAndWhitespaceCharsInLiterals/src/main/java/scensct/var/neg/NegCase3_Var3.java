// Character literals should not be flagged as containing non-explicit control characters in string/numeric literals.
package scensct.var.neg;

public class NegCase3_Var3 {
    public static void main(String[] args) {
        // Use a switch statement to assign and print characters
        char c;
        for (int i = 0; i < 5; i++) {
            switch (i) {
                case 0: c = 'a'; break;
                case 1: c = '\n'; break;
                case 2: c = '\u200B'; break;
                case 3: c = '\t'; break;
                case 4: c = '\u03A9'; break;
                default: c = '?'; break;
            }
            System.out.print(c);
        }
    }
}