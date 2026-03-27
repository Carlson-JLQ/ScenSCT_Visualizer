// User-provided string from HttpServletRequest.getParameter is matched against a polynomial backtracking regex after sanitization via a method containing "header" should not be flagged as ReDoS.
package scensct.var.neg;

import javax.servlet.http.HttpServletRequest;

public class NegCase1_Var2 {
    static class Holder {
        String value;
        Holder(String v) { value = v; }
    }

    public static void main(String[] args) {
        HttpServletRequest request = null;
        String userInput = request.getParameter("input");
        // Sanitization barrier: method name contains "header"
        Holder h = null;
        try {
            h = new Holder(sanitizeHeader(userInput));
        } catch (Exception e) {
            h = new Holder("");
        }
        // Polynomial backtracking regex applied after sanitization
        boolean matches = h.value.matches("(a+)+b");
        System.out.println(matches);
    }

    // Sanitizer method with "header" in name, acting as a barrier
    private static String sanitizeHeader(String input) {
        if (input == null) return "";
        int max = 100;
        int len = input.length();
        while (len > max) {
            len--;
        }
        // Cap length
        return len < input.length() ? input.substring(0, len) : input;
    }
}