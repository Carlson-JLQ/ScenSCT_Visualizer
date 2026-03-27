// Insecure random data passed as first argument to OWASP ESAPI Encoder method and encoded result flows into a SetCookieValue sink should be flagged as insecure randomness usage.
package scensct.var.pos;

import java.util.Random;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class PosCase9_Var4 {
    public static void main(String[] args) {
        // Using Math.random() as an equivalent insecure source
        double insecureDouble = Math.random();
        long insecureLong = (long) (insecureDouble * Long.MAX_VALUE);
        String insecureData = Long.toString(insecureLong);
        String encoded = encodeForSQL(insecureData);
        HttpServletResponse response = null;
        boolean flag = true;
        if (flag && response != null) { // Compound condition
            Cookie cookie = new Cookie("data", encoded); // [REPORTED LINE]
            response.addCookie(cookie);
        }
    }

    static String encodeForSQL(String input) {
        return "encoded_" + input;
    }
}