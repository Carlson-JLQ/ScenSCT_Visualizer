// User input flows to a non-regex sink should not be flagged as regex injection.
package scensct.var.neg;

import java.util.Scanner;
import java.io.Console;

public class NegCase2_Var2 {
    public static void main(String[] args) {
        // Variant 2: Inter-procedural refactoring - extract input reading to a helper method.
        String userInput = readUserInput();
        printOutput(userInput);
    }
    
    private static String readUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    
    private static void printOutput(String input) {
        System.out.printf("User entered: %s%n", input); // Non-regex sink, using printf.
    }
}