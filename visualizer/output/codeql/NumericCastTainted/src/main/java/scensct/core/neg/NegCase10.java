// Narrowing cast of a variable tainted from user source but bounded by conditional check should not be flagged.
package scensct.core.neg;

public class NegCase10 {
    public static void main(String[] args) {
        // Scenario 10: Conditional ensures value is bounded.
        int userInput = Integer.parseInt("500"); // User source.
        if (userInput < 128 && userInput >= -128) {
            byte b = (byte) userInput; // Cast within conditional block.
            System.out.println(b);
        }
    }
}