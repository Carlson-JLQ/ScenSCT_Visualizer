// Insecure random data passed as first argument to OWASP ESAPI Encoder method and encoded result flows into a SetCookieValue sink should be flagged as insecure randomness usage.
package scensct.core.pos;

import java.util.Random;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class PosCase9 {
    public static void main(String[] args) {
        Random insecureRand = new Random(); // Insecure random source
        String insecureData = Long.toString(insecureRand.nextLong());
        String encoded = encodeForSQL(insecureData); // ESAPI encode method, insecure data as first argument
        HttpServletResponse response = null; // Simulated response
        if (response != null) {
            Cookie cookie = new Cookie("data", encoded); // [REPORTED LINE]
            response.addCookie(cookie); // SetCookieValue sink
        }
    }

    static String encodeForSQL(String input) {
        // Simulate OWASP ESAPI Encoder method
        return "encoded_" + input;
    }
}