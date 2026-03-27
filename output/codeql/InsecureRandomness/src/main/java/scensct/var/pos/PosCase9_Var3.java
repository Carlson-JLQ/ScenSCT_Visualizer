// Insecure random data passed as first argument to OWASP ESAPI Encoder method and encoded result flows into a SetCookieValue sink should be flagged as insecure randomness usage.
package scensct.var.pos;

import java.util.Random;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class PosCase9_Var3 {
    public static void main(String[] args) {
        Random insecureRand = new Random();
        String insecureData;
        do {
            insecureData = Long.toString(insecureRand.nextLong());
        } while (false); // Loop that runs exactly once
        String encoded = encodeForSQL(insecureData);
        HttpServletResponse response = null;
        try {
            if (response != null) {
                Cookie cookie = new Cookie("data", encoded); // [REPORTED LINE]
                response.addCookie(cookie);
            }
        } catch (Exception e) {
            // Ignore
        }
    }

    static String encodeForSQL(String input) {
        return "encoded_" + input;
    }
}