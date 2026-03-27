// User-provided string from HttpServletRequest.getParameter is matched against a polynomial backtracking regex after sanitization via a method containing "header" should not be flagged as ReDoS.
package scensct.var.neg;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class NegCase1_Var3 {
    public static void main(String[] args) {
        HttpServletRequest request = null;
        String userInput = request.getParameter("input");
        // Sanitization barrier: method name contains "header"
        String sanitized = sanitizeHeader(userInput);
        // Polynomial backtracking regex applied after sanitization
        boolean matches = checkPattern(sanitized);
        System.out.println(matches);
    }

    private static String sanitizeHeader(String input) {
        if (input == null) return "";
        return restrictLength(input, 100);
    }

    private static String restrictLength(String s, int limit) {
        return s.length() > limit ? s.substring(0, limit) : s;
    }

    private static boolean checkPattern(String text) {
        Pattern p = Pattern.compile("(a+)+b");
        Matcher m = p.matcher(text);
        return m.matches();
    }
}