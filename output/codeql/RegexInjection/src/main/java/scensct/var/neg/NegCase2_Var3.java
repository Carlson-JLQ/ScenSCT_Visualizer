// User input flows to a non-regex sink should not be flagged as regex injection.
package scensct.var.neg;

import java.util.Scanner;

public class NegCase2_Var3 {
    public static void main(String[] args) {
        // Variant 3: Control-flow restructuring - add a conditional branch that doesn't alter the sink.
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        if (userInput.length() > 0) {
            System.out.println("User entered: " + userInput); // Non-regex sink.
        } else {
            System.out.println("User entered nothing.");
        }
    }
}