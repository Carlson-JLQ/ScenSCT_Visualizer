// A recognized threat model source and a command injection sink exist in the same program, but there is no taint flow path connecting the source to the sink should not be flagged as command injection.
package scensct.var.neg;

import java.io.IOException;

public class NegCase4_Var2 {
    public static void main(String[] args) throws IOException {
        String userInput = args[0];
        String safeCommand = buildSafeCommand();
        
        executeCommand(safeCommand);
        
        // Use userInput in a separate path
        logInput(userInput);
    }
    
    private static String buildSafeCommand() {
        return "echo hello";
    }
    
    private static void executeCommand(String cmd) throws IOException {
        Runtime.getRuntime().exec(cmd);
    }
    
    private static void logInput(String input) {
        System.out.println("User provided: " + input);
    }
}