// A taint flow path exists from a recognized threat model source to a command injection sink, but the path includes a sanitizer node that prevents the injection should not be flagged as command injection.
package scensct.core.neg;

import java.io.IOException;

public class NegCase1 {
    public static void main(String[] args) throws IOException {
        // Recognized threat model source: user input via command line argument
        String userInput = args[0];
        
        // Sanitizer node: input validation that removes or neutralizes dangerous characters
        String sanitizedInput = userInput.replaceAll("[;&|<>$`]", "");
        
        // Command injection sink: Runtime.exec with sanitized input
        Runtime.getRuntime().exec("echo " + sanitizedInput);
    }
}