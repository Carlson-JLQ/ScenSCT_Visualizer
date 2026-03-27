// A taint flow from a user-provided source to the format string argument of a String.format call exists, but the flow passes through at least one node with a numeric or boolean type should not be flagged as a format string vulnerability.
package scensct.core.neg;

public class NegCase4 {
    public static void main(String[] args) {
        // Scenario 4: Taint flow passes through a numeric type node.
        String userInput = args[0]; // User-provided source
        int numericIntermediate = Integer.parseInt(userInput); // Converts to numeric type
        // The format string is derived from a numeric type, breaking taint flow for strings.
        String formatString = String.valueOf(numericIntermediate); // Numeric to string conversion
        // The format string argument originates from a numeric node, not directly tainted as a string.
        String result = String.format(formatString, "arg");
        System.out.println(result);
    }
}