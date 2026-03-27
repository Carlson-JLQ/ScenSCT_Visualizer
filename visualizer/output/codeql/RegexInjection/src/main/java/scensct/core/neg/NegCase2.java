// User input flows to a non-regex sink should not be flagged as regex injection.
package scensct.core.neg;

import java.util.Scanner;

public class NegCase2 {
    public static void main(String[] args) {
        // Scenario 2: User input flows to a different sink (console output).
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        System.out.println("User entered: " + userInput); // Non-regex sink.
    }
}