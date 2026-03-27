// A taint flow path exists from a recognized threat model source to a sink that is not a command injection sink should not be flagged as command injection.
package scensct.var.neg;

import java.util.logging.Logger;

public class NegCase3_Var5 {
    private static final Logger LOG = Logger.getLogger(NegCase3_Var5.class.getName());
    
    public static void main(String[] args) {
        // Variant 5: Intra-procedural with try-catch and temporary aliasing
        try {
            String src = args[0];
            String message = new StringBuilder("User input: ").append(src).toString();
            LOG.info(message);
        } catch (ArrayIndexOutOfBoundsException e) {
            LOG.info("No arguments provided");
        }
    }
}