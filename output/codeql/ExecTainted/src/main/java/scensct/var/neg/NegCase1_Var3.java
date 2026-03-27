// A taint flow path exists from a recognized threat model source to a command injection sink, but the path includes a sanitizer node that prevents the injection should not be flagged as command injection.
package scensct.var.neg;

import java.io.IOException;

public class NegCase1_Var3 {
    public static void main(String[] args) throws IOException {
        // Variant 3: Sanitization via conditional replacement in a loop
        String userInput = args[0];
        String[] dangerous = {";", "&", "|", "<", ">", "$", "`"};
        String sanitizedInput = userInput;
        for (String bad : dangerous) {
            sanitizedInput = sanitizedInput.replace(bad, "");
        }
        // Use ProcessBuilder instead of Runtime.exec
        new ProcessBuilder("echo", sanitizedInput).start();
    }
}