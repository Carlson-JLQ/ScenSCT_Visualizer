// A method call that uses a format string argument but is not a call to String.format should not be flagged as a format string vulnerability.
package scensct.var.neg;

import java.util.Formatter;

public class NegCase1_Var1 {
    public static void main(String[] args) {
        // Variant 1: Lexical refactoring - rename variables, use different expression for tainted source.
        String userInput = args[0]; // renamed
        Formatter fmt = new Formatter(); // renamed
        // Same call, different variable names.
        fmt.format(userInput, "safeArg");
        System.out.println(fmt.toString());
    }
}