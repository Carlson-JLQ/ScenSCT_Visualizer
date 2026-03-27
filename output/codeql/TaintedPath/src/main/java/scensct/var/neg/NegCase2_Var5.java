// Tainted source used only in non-path operations should not be flagged as path injection.
package scensct.var.neg;

import javax.servlet.http.HttpServletRequest;

public class NegCase2_Var5 {
    // Variant 5: Try-catch and multiple non-path usages
    public void processRequest(HttpServletRequest request) {
        try {
            String userInput = request.getParameter("data");
            // Use in print, length check, but never in path operation
            System.out.print("Received: ");
            System.out.println(userInput);
            int len = userInput == null ? 0 : userInput.length();
            System.out.println("Length: " + len);
        } catch (Exception e) {
            System.err.println("Error reading input");
        }
    }
}