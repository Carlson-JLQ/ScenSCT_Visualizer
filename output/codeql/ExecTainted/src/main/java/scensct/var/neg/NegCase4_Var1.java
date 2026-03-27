// A recognized threat model source and a command injection sink exist in the same program, but there is no taint flow path connecting the source to the sink should not be flagged as command injection.
package scensct.var.neg;

import java.io.IOException;

public class NegCase4_Var1 {
    public static void main(String[] args) throws IOException {
        String userInput = args[0];
        String safeBase = "echo";
        String safeArg = "hello";
        
        // Branch that does not affect the safe command
        String safeCommand;
        if (userInput.length() > 5) {
            safeCommand = safeBase + " " + safeArg;
        } else {
            safeCommand = safeBase + " " + safeArg;
        }
        
        // Alias reference
        String cmd = safeCommand;
        Runtime.getRuntime().exec(cmd);
        
        System.out.println("User provided: " + userInput);
    }
}