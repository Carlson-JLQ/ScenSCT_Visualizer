// Directly using a tainted method parameter as the format string in String.format should be flagged as a format string vulnerability.
package scensct.ref.pos;

public class PosCase1_FN1 {
    // Simulating a taint source annotation; in real checker, this would be a recognized annotation.
    // The method parameter 'format' is externally controlled.
    public static void vulnerableFormat(String format) {
        // Tainted data flows directly to format string argument
        String result = String.format(format, "safeArgument");
        System.out.println(result);
    }

    public static void main(String[] args) {
        vulnerableFormat(args[0]); // User input from command line
    }
}