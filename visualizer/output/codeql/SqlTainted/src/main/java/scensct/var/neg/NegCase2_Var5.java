// User data flowing to non-SQL sink should not be flagged as SQL injection.
package scensct.var.neg;

import javax.servlet.http.HttpServletRequest;

public class NegCase2_Var5 {
    // Variant 5: Use a try-catch block, but the sink remains non-SQL.
    public void doGet(HttpServletRequest request) {
        try {
            String userInput = request.getParameter("input");
            // Simulate some processing that might throw, but doesn't change the sink.
            if (userInput.length() > 100) {
                throw new IllegalArgumentException("Too long");
            }
            System.out.println("Processed input: " + userInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input");
        }
    }
}