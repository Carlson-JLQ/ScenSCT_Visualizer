// Sanitized user input before regex compilation should not be flagged as regex injection.
package scensct.var.neg;

import java.util.Scanner;
import java.util.regex.Pattern;

public class NegCase5_Var2 {
    public static void main(String[] args) {
        // Try-with-resources for Scanner
        try (Scanner sc = new Scanner(System.in)) {
            String input = sc.nextLine();
            // Inline sanitization into a helper method call
            Pattern p = compileSafe(input);
            System.out.println(p.matcher(input).matches());
        }
    }

    private static Pattern compileSafe(String userInput) {
        // Helper method that still sanitizes
        return Pattern.compile(Pattern.quote(userInput));
    }
}