// Narrowing cast of a variable not tainted by the user source present should not be flagged.
package scensct.core.neg;

public class NegCase4 {
    public static void main(String[] args) {
        // Scenario 4: User source taints different sink.
        int userInput = Integer.parseInt("123"); // User source.
        int safeInt = 50; // Not from user source.
        byte b = (byte) safeInt; // Cast of non-tainted variable.
        System.out.println(b);
        // userInput is not used in the cast, so no taint flow to the cast.
    }
}