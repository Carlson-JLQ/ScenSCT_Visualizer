// Sanitized user input before regex compilation should not be flagged as regex injection.
package scensct.var.neg;

import java.util.Scanner;
import java.util.regex.Pattern;

public class NegCase5_Var4 {
    public static void main(String[] args) {
        // Extract the entire flow into a separate method
        processInput();
    }

    private static void processInput() {
        Scanner scanner = new Scanner(System.in);
        String fromUser = scanner.nextLine();
        // Sanitization via a separate sanitizer method
        String sanitized = sanitizeForRegex(fromUser);
        Pattern p = Pattern.compile(sanitized);
        System.out.println(p.matcher(fromUser).matches());
    }

    private static String sanitizeForRegex(String s) {
        // Delegates to Pattern.quote
        return Pattern.quote(s);
    }
}