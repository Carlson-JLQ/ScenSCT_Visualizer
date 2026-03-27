// A taint flow path exists from a recognized threat model source to a command injection sink, but the path includes a sanitizer node that prevents the injection should not be flagged as command injection.
package scensct.var.neg;

import java.io.IOException;

public class NegCase1_Var2 {
    // Helper method for sanitization
    private static String stripShellMetacharacters(String input) {
        return input.replaceAll("[;&|<>$`]", "");
    }

    public static void main(String[] args) throws IOException {
        String userInput = args[0];
        // Sanitization extracted to a separate method
        String sanitizedInput = stripShellMetacharacters(userInput);
        // Sink remains in main
        Runtime.getRuntime().exec("echo " + sanitizedInput);
    }
}