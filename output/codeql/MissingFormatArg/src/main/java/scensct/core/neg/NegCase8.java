// A recognized format method call with known format specifiers but undetermined argument count should not be flagged.
package scensct.core.neg;

public class NegCase8 {
    static Object[] getArgs() {
        return new Object[]{"world"};
    }
    public static void main(String[] args) {
        // Scenario 8: Argument count from method return cannot be determined
        String result = String.format("Hello %s", getArgs()); // Argument count unknown
    }
}