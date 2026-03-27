// User-provided string from HttpServletRequest.getParameter is matched against a polynomial backtracking regex after sanitization via a method containing "header" should not be flagged as ReDoS.
package scensct.var.neg;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

public class NegCase1_Var1 {
    public static void main(String[] args) {
        HttpServletRequest req = null; // Simulated request
        String raw = req.getParameter("input");
        // Sanitization barrier: method name contains "header"
        String processed = cleanHeader(raw);
        // Polynomial backtracking regex (e.g., (a+)+b) applied after sanitization
        Pattern p = Pattern.compile("(a+)+b");
        boolean result = p.matcher(processed).matches();
        System.out.println(result);
    }

    // Sanitizer method with "header" in name, acting as a barrier
    private static String cleanHeader(String data) {
        if (data == null) {
            return "";
        }
        // Simple length restriction as example sanitization
        int limit = 100;
        return data.length() > limit ? data.substring(0, limit) : data;
    }
}