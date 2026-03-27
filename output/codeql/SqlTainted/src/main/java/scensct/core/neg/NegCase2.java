// User data flowing to non-SQL sink should not be flagged as SQL injection.
package scensct.core.neg;

import javax.servlet.http.HttpServletRequest;

public class NegCase2 {
    public void doGet(HttpServletRequest request) {
        // Scenario: User-controlled source flows to non-SQL sink.
        String userInput = request.getParameter("input");
        // Non-SQL sink: logging or output, no SQL execution.
        System.out.println("User input: " + userInput);
    }
}