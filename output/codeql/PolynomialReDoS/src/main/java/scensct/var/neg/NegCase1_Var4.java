// User-provided string from HttpServletRequest.getParameter is matched against a polynomial backtracking regex after sanitization via a method containing "header" should not be flagged as ReDoS.
package scensct.var.neg;

import javax.servlet.http.HttpServletRequest;

public class NegCase1_Var4 {
    public static void main(String[] args) {
        HttpServletRequest request = null;
        CharSequence seq = sanitizeHeader(request.getParameter("input"));
        String sanitized = seq == null ? "" : seq.toString().trim();
        // Polynomial backtracking regex applied after sanitization
        boolean matches = sanitized.matches("(a+)+b");
        System.out.println(matches);
    }

    // Sanitizer method with "header" in name, acting as a barrier
    private static CharSequence sanitizeHeader(String input) {
        if (input == null) return "";
        // Simple length restriction as example sanitization
        final int MAX_LEN = 100;
        if (input.length() > MAX_LEN) {
            return input.subSequence(0, MAX_LEN);
        }
        return input;
    }
}