// Insecure random data passed as first argument to OWASP ESAPI Encoder method and encoded result flows into a SetCookieValue sink should be flagged as insecure randomness usage.
package scensct.var.pos;

import java.util.Random;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class PosCase9_Var5 {
    public static void main(String[] args) {
        Random insecureRand = new Random();
        String encoded = encodeForSQL(Long.toString(insecureRand.nextLong())); // Inlined
        HttpServletResponse response = null;
        if (response != null) {
            // Introduce a temporary variable
            String cookieValue = encoded;
            Cookie cookie = new Cookie("data", cookieValue); // [REPORTED LINE]
            response.addCookie(cookie);
        }
    }

    static String encodeForSQL(String input) {
        // Simulate OWASP ESAPI Encoder method with a ternary
        return input == null ? "encoded_null" : "encoded_" + input;
    }
}