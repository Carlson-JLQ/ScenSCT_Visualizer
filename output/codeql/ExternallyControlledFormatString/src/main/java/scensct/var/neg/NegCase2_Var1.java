// A call to String.format where a tainted value is passed as a substitution argument, not as the format string argument should not be flagged as a format string vulnerability.
package scensct.var.neg;

public class NegCase2_Var1 {
    // Variant 1: Lexical refactoring with reordered statements and renamed variables.
    public static void main(String[] args) {
        String userInput = args[0]; // tainted substitution argument
        final String fmt = "Value: " + "%s"; // compile-time constant format string
        String output = String.format(fmt, userInput);
        System.out.println(output);
    }
}