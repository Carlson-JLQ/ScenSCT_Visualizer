// A method call where the called method is not a recognized format method should not be flagged.
package scensct.core.neg;

public class NegCase2 {
    public static void main(String[] args) {
        // Scenario 2: Non-format method call without enclosing format-like parameters
        System.out.println("Hello"); // No format specifiers, not a format method
    }
}