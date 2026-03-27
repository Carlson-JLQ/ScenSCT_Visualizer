// Insecure random data passed as first argument to OWASP ESAPI Encoder method and encoded result flows into a SetCookieValue sink should be flagged as insecure randomness usage.
package scensct.var.pos;

import java.util.Random;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class PosCase9_Var1 {
    public static void main(String[] args) {
        Random rng = new Random(); // Renamed source
        long raw = rng.nextLong();
        String data = Long.toString(raw); // Split into two steps
        String processed = encodeForSQL(data);
        HttpServletResponse res = null;
        if (res == null) {
            return; // Dead branch, but flow remains reachable
        }
        Cookie c = new Cookie("data", processed); // Aliasing // [REPORTED LINE]
        res.addCookie(c);
    }

    static String encodeForSQL(String input) {
        return "encoded_" + input;
    }
}