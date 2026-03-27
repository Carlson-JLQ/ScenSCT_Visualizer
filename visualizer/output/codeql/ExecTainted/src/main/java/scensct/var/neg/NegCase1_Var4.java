// A taint flow path exists from a recognized threat model source to a command injection sink, but the path includes a sanitizer node that prevents the injection should not be flagged as command injection.
package scensct.var.neg;

import java.io.IOException;

public class NegCase1_Var4 {
    public static void main(String[] args) throws IOException {
        // Variant 4: Sanitization with try-catch and temporary variable aliasing
        String src = args[0];
        String intermediate = src;
        // Aliasing and sanitization
        String cleaned = intermediate.replaceAll("[;&|<>$`]", "");
        try {
            Runtime.getRuntime().exec("echo " + cleaned);
        } finally {
            // Some cleanup logic that doesn't affect the flow
            System.gc();
        }
    }
}