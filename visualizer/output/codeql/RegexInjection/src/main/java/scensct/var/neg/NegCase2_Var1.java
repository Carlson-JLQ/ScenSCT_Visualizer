// User input flows to a non-regex sink should not be flagged as regex injection.
package scensct.var.neg;

import java.util.Scanner;

public class NegCase2_Var1 {
    public static void main(String[] args) {
        // Variant 1: Lexical refactoring - rename variables, split operations, use different Scanner method.
        Scanner inputReader = new Scanner(System.in);
        String data = inputReader.next(); // Changed to next() instead of nextLine()
        String message = "User entered: " + data;
        System.out.println(message); // Non-regex sink.
    }
}