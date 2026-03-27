// User-provided string from HttpServletRequest.getParameter is matched against a polynomial backtracking regex after sanitization via a method containing "header" should not be flagged as ReDoS.
package scensct.var.neg;

import javax.servlet.http.HttpServletRequest;
import java.util.function.Predicate;

public class NegCase1_Var5 {
    private static String sanitizedInput;

    public static void main(String[] args) {
        HttpServletRequest request = null;
        String fromUser = request.getParameter("input");
        prepareSanitized(fromUser);
        // Polynomial backtracking regex applied after sanitization
        Predicate<String> tester = s -> s.matches("(a+)+b");
        boolean matches = tester.test(sanitizedInput);
        System.out.println(matches);
    }

    private static void prepareSanitized(String raw) {
        sanitizedInput = sanitizeHeader(raw);
    }

    // Sanitizer method with "header" in name, acting as a barrier
    private static String sanitizeHeader(String input) {
        if (input == null) return "";
        int len = input.length();
        switch (len > 100 ? 1 : 0) {
            case 1: return input.substring(0, 100);
            default: return input;
        }
    }
}