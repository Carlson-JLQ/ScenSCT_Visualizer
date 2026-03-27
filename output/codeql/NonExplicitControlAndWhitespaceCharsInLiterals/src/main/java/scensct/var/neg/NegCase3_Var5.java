// Character literals should not be flagged as containing non-explicit control characters in string/numeric literals.
package scensct.var.neg;

public class NegCase3_Var5 {
    public static void main(String[] args) {
        // Use character literals with octal escapes and nested assignments
        char ch1 = 'a', ch2 = '\012'; // octal for newline
        char ch3 = '\u200B';
        char ch4 = '\011'; // octal for tab
        char ch5 = '\u03A9';
        
        // Print using a StringBuilder (but still character literals as source)
        StringBuilder sb = new StringBuilder();
        sb.append(ch1).append(ch2).append(ch3).append(ch4).append(ch5);
        System.out.print(sb.toString());
    }
}