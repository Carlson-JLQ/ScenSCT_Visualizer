// A method call that uses a format string argument but is not a call to String.format should not be flagged as a format string vulnerability.
package scensct.core.neg;

import java.util.Formatter;

public class NegCase1 {
    public static void main(String[] args) {
        // Scenario 1: Using Formatter.format, not String.format, with tainted format string.
        // The checker should not flag non-String.format formatting methods.
        String taintedFormat = args[0]; // User-provided source
        Formatter formatter = new Formatter();
        // This call uses a tainted format string, but it's not String.format.
        formatter.format(taintedFormat, "safeArg");
        System.out.println(formatter.toString());
    }
}