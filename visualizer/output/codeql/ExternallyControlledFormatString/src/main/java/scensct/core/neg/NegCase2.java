// A call to String.format where a tainted value is passed as a substitution argument, not as the format string argument should not be flagged as a format string vulnerability.
package scensct.core.neg;

public class NegCase2 {
    public static void main(String[] args) {
        // Scenario 2: Tainted value is a substitution argument, not the format string.
        String safeFormat = "Value: %s"; // Safe, constant format string
        String taintedArg = args[0]; // User-provided source as substitution argument
        // Only the substitution argument is tainted, not the format string.
        String result = String.format(safeFormat, taintedArg);
        System.out.println(result);
    }
}