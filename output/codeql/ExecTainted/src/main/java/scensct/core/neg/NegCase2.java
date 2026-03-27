// A taint flow path exists from a source that is not a recognized threat model source to a command injection sink should not be flagged as command injection.
package scensct.core.neg;

import java.io.IOException;

public class NegCase2 {
    public static void main(String[] args) throws IOException {
        // Source that is NOT a recognized threat model source: constant string
        String constantInput = "safe_constant_string";
        
        // Command injection sink: Runtime.exec with constant input
        Runtime.getRuntime().exec("echo " + constantInput);
    }
}