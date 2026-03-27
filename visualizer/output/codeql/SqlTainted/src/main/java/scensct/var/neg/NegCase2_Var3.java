// User data flowing to non-SQL sink should not be flagged as SQL injection.
package scensct.var.neg;

import javax.servlet.http.HttpServletRequest;

public class NegCase2_Var3 {
    // Variant 3: Control flow with a branch that doesn't affect the sink.
    public void doGet(HttpServletRequest request) {
        String userInput = request.getParameter("input");
        if (userInput == null) {
            userInput = "default";
        }
        // Non-SQL sink after conditional assignment.
        System.err.println("Error log: " + userInput); // Different output stream, still non-SQL
    }
}