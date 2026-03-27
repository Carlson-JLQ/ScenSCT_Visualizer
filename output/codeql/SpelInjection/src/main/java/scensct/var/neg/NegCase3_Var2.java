// Threat source flows but does not reach any SpEL evaluation sink.
package scensct.var.neg;

import javax.servlet.http.HttpServletRequest;

public class NegCase3_Var2 {
    public void handleRequest(HttpServletRequest request) {
        String userInput = extractParam(request, "data");
        // Loop that processes characters but no SpEL
        StringBuilder builder = new StringBuilder();
        for (char c : userInput.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                builder.append(c);
            }
        }
        logResult(builder.toString());
    }

    private String extractParam(HttpServletRequest req, String key) {
        return req.getParameter(key);
    }

    private void logResult(String msg) {
        System.out.println("Logged: " + msg);
        // No SpEL here
    }
}