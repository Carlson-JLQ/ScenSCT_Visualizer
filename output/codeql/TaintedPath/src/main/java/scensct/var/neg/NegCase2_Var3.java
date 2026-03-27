// Tainted source used only in non-path operations should not be flagged as path injection.
package scensct.var.neg;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

public class NegCase2_Var3 {
    // Variant 3: Idiomatic variation with Logger
    private static final Logger LOG = Logger.getLogger(NegCase2_Var3.class.getName());

    public void processRequest(HttpServletRequest request) {
        String userInput = request.getParameter("data");
        // Use standard logging instead of System.out
        LOG.info(() -> "Received: " + userInput);
    }
}