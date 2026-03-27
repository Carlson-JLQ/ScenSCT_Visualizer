// A recognized threat model source and a command injection sink exist in the same program, but there is no taint flow path connecting the source to the sink should not be flagged as command injection.
package scensct.core.neg;

import java.io.IOException;

public class NegCase4 {
    public static void main(String[] args) throws IOException {
        // Recognized threat model source: user input via command line argument
        String userInput = args[0];
        
        // Independent variable not derived from user input
        String safeCommand = "echo hello";
        
        // Command injection sink using safe command (no taint flow from userInput)
        Runtime.getRuntime().exec(safeCommand);
        
        // User input is used elsewhere but doesn't flow to the sink
        System.out.println("User provided: " + userInput);
    }
}