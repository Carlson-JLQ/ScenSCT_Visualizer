// Isolated user input with no flow to regex sink should not be flagged as regex injection.
package scensct.var.neg;

import java.util.Scanner;

public class NegCase3_Var2 {
    public static void main(String[] args) {
        // Variant 2: Intra-procedural restructuring - introduce temporary variable and control flow that does not connect source to sink.
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String patternStr;
        if (System.currentTimeMillis() % 2 == 0) {
            patternStr = "\\w+";
        } else {
            patternStr = "\\d+";
        }
        // userInput is never used in pattern construction.
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(patternStr);
        boolean result = pattern.matcher("123").matches();
        System.out.println(result);
    }
}