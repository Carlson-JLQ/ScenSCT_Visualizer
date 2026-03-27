// User input flows to a different sink, not reaching regex compilation should not be flagged as regex injection.
package scensct.core.neg;

import java.util.Scanner;

public class NegCase4 {
    public static void main(String[] args) {
        // Scenario 4: User input flows to a different sink (string concatenation), not to regex.
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String result = "Prefix " + userInput; // Different sink.
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("^Prefix.*");
        System.out.println(pattern.matcher(result).matches());
    }
}