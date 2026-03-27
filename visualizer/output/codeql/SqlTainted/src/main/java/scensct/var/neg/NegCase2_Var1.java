// User data flowing to non-SQL sink should not be flagged as SQL injection.
package scensct.var.neg;

import javax.servlet.http.HttpServletRequest;

public class NegCase2_Var1 {
    public void doGet(HttpServletRequest request) {
        // Variant 1: Introduce an alias and a temporary variable with a different type.
        String param = request.getParameter("input");
        CharSequence seq = param; // Alias via supertype
        String userInput = seq.toString(); // Convert back
        // Still a non-SQL sink: logging
        System.out.println("Logged: " + userInput);
    }
}