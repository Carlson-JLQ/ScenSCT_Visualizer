// Insecure random data passed as first argument to OWASP ESAPI Encoder method and encoded result flows into a SetCookieValue sink should be flagged as insecure randomness usage.
package scensct.var.pos;

import java.util.Random;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class PosCase9_Var2 {
    public static void main(String[] args) {
        String val = getInsecureRandomString();
        String safe = encodeForSQL(val);
        HttpServletResponse response = getResponse();
        if (response != null) {
            setCookie(response, safe);
        }
    }

    static String getInsecureRandomString() {
        Random rand = new Random();
        return Long.toString(rand.nextLong());
    }

    static HttpServletResponse getResponse() {
        return null;
    }

    static void setCookie(HttpServletResponse resp, String value) {
        Cookie cookie = new Cookie("data", value); // [REPORTED LINE]
        resp.addCookie(cookie);
    }

    static String encodeForSQL(String input) {
        return "encoded_" + input;
    }
}