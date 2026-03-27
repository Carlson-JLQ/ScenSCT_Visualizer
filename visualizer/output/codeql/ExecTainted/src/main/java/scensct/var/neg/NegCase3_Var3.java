// A taint flow path exists from a recognized threat model source to a sink that is not a command injection sink should not be flagged as command injection.
package scensct.var.neg;

import java.util.logging.Logger;

public class NegCase3_Var3 {
    private static final Logger LOG = Logger.getLogger(NegCase3_Var3.class.getName());
    
    // Variant 3: Inter-procedural refactoring - extract source and sink into helper methods
    private static String getUserInput(String[] args) {
        return args[0];
    }
    
    private static void logInput(String input) {
        LOG.info("User input: " + input);
    }
    
    public static void main(String[] args) {
        String userInput = getUserInput(args);
        logInput(userInput);
    }
}