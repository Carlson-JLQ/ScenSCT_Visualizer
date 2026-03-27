// A recognized threat model source and a command injection sink exist in the same program, but there is no taint flow path connecting the source to the sink should not be flagged as command injection.
package scensct.var.neg;

import java.io.IOException;

public class NegCase4_Var4 {
    private static final String[] SAFE_WORDS = {"echo", "hello"};
    
    public static void main(String[] args) throws IOException {
        String userInput = args[0];
        String safeCommand = SAFE_WORDS[0] + " " + SAFE_WORDS[1];
        
        try {
            Runtime.getRuntime().exec(safeCommand);
        } catch (IOException e) {
            System.err.println("Command failed: " + e.getMessage());
        }
        
        System.out.println("User entered: " + userInput);
    }
}