// A recognized format method call with indeterminate format string should not be flagged.
package scensct.core.neg;

public class NegCase6 {
    public static void main(String[] args) {
        // Scenario 6: Format string is a variable, cannot be determined statically
        String format = args.length > 0 ? args[0] : "Hello %s";
        String result = String.format(format, "world"); // format string indeterminate
    }
}