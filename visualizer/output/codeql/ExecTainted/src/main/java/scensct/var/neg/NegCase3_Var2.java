// A taint flow path exists from a recognized threat model source to a sink that is not a command injection sink should not be flagged as command injection.
package scensct.var.neg;

import java.util.logging.Logger;

public class NegCase3_Var2 {
    private static final Logger LOG = Logger.getLogger(NegCase3_Var2.class.getName());
    
    public static void main(String[] args) {
        // Variant 2: Intra-procedural control flow restructuring with if-else
        if (args.length == 0) {
            LOG.info("No input provided");
        } else {
            String userInput = args[0];
            LOG.info("User input: " + userInput);
        }
    }
}