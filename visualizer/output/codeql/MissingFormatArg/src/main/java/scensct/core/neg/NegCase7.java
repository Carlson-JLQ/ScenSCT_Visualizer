// A recognized format method call with format string having undetermined max specifier index should not be flagged.
package scensct.core.neg;

public class NegCase7 {
    public static void main(String[] args) {
        // Scenario 7: Malformed format specifier, max index cannot be determined
        String result = String.format("Hello %", "world"); // Invalid format specifier
    }
}