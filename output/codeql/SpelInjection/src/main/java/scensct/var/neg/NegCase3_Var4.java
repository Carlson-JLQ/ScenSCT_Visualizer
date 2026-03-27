// Threat source flows but does not reach any SpEL evaluation sink.
package scensct.var.neg;

import javax.servlet.http.HttpServletRequest;

public class NegCase3_Var4 {
    public void handleRequest(HttpServletRequest request) {
        try {
            String userInput = request.getParameter("data");
            // Simulate processing that could throw but no SpEL
            String result = processSafely(userInput);
            System.out.println(result);
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid input: " + e.getMessage());
        }
    }

    private String processSafely(String input) {
        if (input == null) {
            throw new IllegalArgumentException("null input");
        }
        return input.trim().toUpperCase();
    }
}