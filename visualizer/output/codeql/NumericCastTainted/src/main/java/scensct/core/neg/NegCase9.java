// Narrowing cast of a variable tainted from user source but limited by right shift operation should not be flagged.
package scensct.core.neg;

public class NegCase9 {
    public static void main(String[] args) {
        // Scenario 9: Value limited via right shift.
        int userInput = Integer.parseInt("1000"); // User source.
        int shifted = userInput >> 4; // Right shift reduces range.
        byte b = (byte) shifted; // Cast of shifted variable.
        System.out.println(b);
    }
}