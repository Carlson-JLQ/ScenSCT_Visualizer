// A taint flow path exists from a recognized threat model source to a command injection sink, but the path includes a sanitizer node that prevents the injection should not be flagged as command injection.
package scensct.var.neg;

import java.io.IOException;

public class NegCase1_Var1 {
    public static void main(String[] args) throws IOException {
        // Variant 1: Sanitization via explicit allowlist of safe characters
        String userInput = args[0];
        StringBuilder safe = new StringBuilder();
        for (char c : userInput.toCharArray()) {
            if (Character.isLetterOrDigit(c) || c == ' ' || c == '.' || c == '-') {
                safe.append(c);
            }
        }
        String sanitizedInput = safe.toString();
        Runtime.getRuntime().exec("echo " + sanitizedInput);
    }
}