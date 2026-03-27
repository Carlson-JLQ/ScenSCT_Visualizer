// A taint flow path exists from a source that is not a recognized threat model source to a command injection sink should not be flagged as command injection.
package scensct.var.neg;

import java.io.IOException;

public class NegCase2_Var5 {
    private static final String SAFE_CONSTANT = "safe_constant_string";
    
    private static String buildCommand(String arg) {
        return "echo " + arg;
    }
    
    public static void main(String[] args) throws IOException {
        String cmd = buildCommand(SAFE_CONSTANT);
        Runtime.getRuntime().exec(cmd);
    }
}