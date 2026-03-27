// The format string argument in a String.format call originates from a non-user-provided source should not be flagged as a format string vulnerability.
package scensct.core.neg;

public class NegCase3 {
    public static void main(String[] args) {
        // Scenario 3: Format string is a constant literal, not tainted.
        final String CONSTANT_FORMAT = "Constant: %d"; // Non-user-provided source
        int value = 42;
        // Format string is safe, originating from a constant.
        String result = String.format(CONSTANT_FORMAT, value);
        System.out.println(result);
    }
}