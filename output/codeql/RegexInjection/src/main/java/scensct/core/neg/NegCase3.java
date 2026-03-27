// Isolated user input with no flow to regex sink should not be flagged as regex injection.
package scensct.core.neg;

import java.util.Scanner;

public class NegCase3 {
    public static void main(String[] args) {
        // Scenario 3: User input exists but is isolated, no data flow to regex compilation.
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine(); // Source isolated.
        // No use of userInput; regex uses a constant.
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("\\w+");
        System.out.println(pattern.matcher("test").matches());
    }
}