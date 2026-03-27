// A taint flow path exists from a recognized threat model source to a sink that is not a command injection sink should not be flagged as command injection.
package scensct.var.neg;

import java.util.logging.Logger;

public class NegCase3_Var1 {
    private static final Logger LOG = Logger.getLogger(NegCase3_Var1.class.getName());
    
    public static void main(String[] args) {
        // Variant 1: Lexical refactoring with temporary variable and expression rewrite
        String source = args.length > 0 ? args[0] : "";
        String logMessage = "User input: ".concat(source);
        LOG.info(logMessage);
    }
}