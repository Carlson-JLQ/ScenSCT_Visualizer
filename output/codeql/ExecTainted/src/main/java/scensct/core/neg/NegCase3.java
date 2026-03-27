// A taint flow path exists from a recognized threat model source to a sink that is not a command injection sink should not be flagged as command injection.
package scensct.core.neg;

import java.util.logging.Logger;

public class NegCase3 {
    private static final Logger LOG = Logger.getLogger(NegCase3.class.getName());
    
    public static void main(String[] args) {
        // Recognized threat model source: user input via command line argument
        String userInput = args[0];
        
        // Sink that is NOT a command injection sink: logging output
        LOG.info("User input: " + userInput);
    }
}