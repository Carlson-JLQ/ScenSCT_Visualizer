// Sanitized user input before regex compilation should not be flagged as regex injection.
package scensct.var.neg;

import java.util.Scanner;
import java.util.regex.Pattern;

public class NegCase5_Var3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        // Introduce a temporary variable and a redundant condition
        boolean shouldSanitize = true;
        String toCompile = shouldSanitize ? Pattern.quote(userInput) : userInput;
        // The ternary always picks the safe branch
        Pattern pattern = Pattern.compile(toCompile);
        System.out.println(pattern.matcher(userInput).matches());
    }
}