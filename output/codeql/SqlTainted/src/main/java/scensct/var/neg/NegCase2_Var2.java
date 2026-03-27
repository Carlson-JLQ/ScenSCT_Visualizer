// User data flowing to non-SQL sink should not be flagged as SQL injection.
package scensct.var.neg;

import javax.servlet.http.HttpServletRequest;

public class NegCase2_Var2 {
    // Variant 2: Extract the sink into a helper method, but keep it non-SQL.
    public void doGet(HttpServletRequest request) {
        String userInput = request.getParameter("input");
        logUserInput(userInput);
    }

    private void logUserInput(String input) {
        // Helper method that performs the non-SQL output.
        System.out.println("User provided: " + input);
    }
}