// User-provided string from HttpServletRequest.getParameter is matched against a polynomial backtracking regex after sanitization via a method containing "header" should not be flagged as ReDoS.
package scensct.core.neg;

import javax.servlet.http.HttpServletRequest;

public class NegCase1 {
    public static void main(String[] args) {
        HttpServletRequest request = null; // Simulated request
        String userInput = request.getParameter("input");
        // Sanitization barrier: method name contains "header"
        String sanitized = sanitizeHeader(userInput);
        // Polynomial backtracking regex (e.g., (a+)+b) applied after sanitization
        boolean matches = sanitized.matches("(a+)+b");
        System.out.println(matches);
    }

    // Sanitizer method with "header" in name, acting as a barrier
    private static String sanitizeHeader(String input) {
        if (input == null) return "";
        // Simple length restriction as example sanitization
        return input.length() > 100 ? input.substring(0, 100) : input;
    }
}