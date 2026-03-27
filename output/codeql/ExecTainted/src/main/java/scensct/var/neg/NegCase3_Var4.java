// A taint flow path exists from a recognized threat model source to a sink that is not a command injection sink should not be flagged as command injection.
package scensct.var.neg;

import java.util.logging.Logger;
import java.util.logging.Level;

public class NegCase3_Var4 {
    private static final Logger LOG = Logger.getLogger(NegCase3_Var4.class.getName());
    
    public static void main(String[] args) {
        // Variant 4: Idiomatic variation - using different logging method and source via System property fallback
        String userInput = args.length > 0 ? args[0] : System.getProperty("user.input", "");
        LOG.log(Level.INFO, "User input: {0}", userInput);
    }
}