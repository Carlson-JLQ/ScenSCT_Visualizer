// A recognized format method call with specifier count <= argument count should not be flagged.
package scensct.core.neg;

public class NegCase9 {
    public static void main(String[] args) {
        // Scenario 9: No mismatch - one specifier, one argument
        String result = String.format("Hello %s", "world"); // Correct number of arguments
    }
}