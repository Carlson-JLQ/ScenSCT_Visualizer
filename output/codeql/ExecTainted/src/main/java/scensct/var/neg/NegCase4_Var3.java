// A recognized threat model source and a command injection sink exist in the same program, but there is no taint flow path connecting the source to the sink should not be flagged as command injection.
package scensct.var.neg;

import java.io.IOException;

public class NegCase4_Var3 {
    public static void main(String[] args) throws IOException {
        String userInput = args[0];
        StringBuilder sb = new StringBuilder();
        String[] parts = {"echo", " ", "hello"};
        
        for (String p : parts) {
            sb.append(p);
        }
        String safeCommand = sb.toString();
        
        Runtime.getRuntime().exec(safeCommand);
        
        // Use userInput in an unrelated conditional
        if (userInput.isEmpty()) {
            System.out.println("No input given");
        } else {
            System.out.println("Input length: " + userInput.length());
        }
    }
}