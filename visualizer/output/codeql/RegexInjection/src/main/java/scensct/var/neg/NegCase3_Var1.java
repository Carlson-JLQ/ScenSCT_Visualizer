// Isolated user input with no flow to regex sink should not be flagged as regex injection.
package scensct.var.neg;

import java.util.Scanner;

public class NegCase3_Var1 {
    public static void main(String[] args) {
        // Variant 1: Lexical refactoring - rename variables, split declaration, use different Scanner method.
        Scanner inputScanner = new Scanner(System.in);
        String data = inputScanner.next(); // Changed to next() but still isolated.
        final String regexLiteral = "\\w+";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(regexLiteral);
        System.out.println(p.matcher("sample").matches());
    }
}