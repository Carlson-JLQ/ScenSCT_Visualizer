// Narrowing cast to byte of a variable tainted from user source but bounded below 0 and above less than 256 should not be flagged.
package scensct.core.neg;

public class NegCase8 {
    public static void main(String[] args) {
        // Scenario 8: Value bounded between 0 (inclusive) and 255 (exclusive).
        int userInput = Integer.parseInt("150"); // User source, value 0 <= userInput < 256.
        if (userInput < 0 || userInput >= 256) {
            throw new RuntimeException("Out of range");
        }
        byte b = (byte) userInput; // Cast of bounded variable.
        System.out.println(b);
    }
}