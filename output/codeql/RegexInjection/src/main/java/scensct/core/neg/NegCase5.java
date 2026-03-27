// Sanitized user input before regex compilation should not be flagged as regex injection.
package scensct.core.neg;

import java.util.Scanner;

public class NegCase5 {
    public static void main(String[] args) {
        // Scenario 5: User input is sanitized (escaped) before regex compilation.
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        // Sanitization: escape regex metacharacters.
        String sanitized = java.util.regex.Pattern.quote(userInput);
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(sanitized);
        System.out.println(pattern.matcher(userInput).matches());
    }
}