// A taint flow path exists from a recognized threat model source to a command injection sink, but the path includes a sanitizer node that prevents the injection should not be flagged as command injection.
package scensct.var.neg;

import java.io.IOException;

public class NegCase1_Var5 {
    // Helper that both sanitizes and executes
    private static void safeEcho(String input) throws IOException {
        String sanitized = input.replaceAll("[;&|<>$`]", "");
        Runtime.getRuntime().exec("echo " + sanitized);
    }

    public static void main(String[] args) throws IOException {
        // Entire flow moved into a helper method
        safeEcho(args[0]);
    }
}