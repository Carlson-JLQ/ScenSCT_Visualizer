// Insecure random data passed to UUID constructor and resulting UUID flows into a SetCookieValue sink should be flagged as insecure randomness usage.
package scensct.var.pos;

import java.util.Random;
import java.util.UUID;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class PosCase4_Var1 {
    public static void main(String[] args) {
        Random rng = new Random(); // Renamed variable
        long msb = rng.nextLong();
        long lsb = rng.nextLong();
        UUID id = new UUID(msb, lsb);
        HttpServletResponse resp = getResponse();
        if (resp != null) {
            Cookie c = new Cookie("sessionId", id.toString()); // [REPORTED LINE]
            resp.addCookie(c);
        }
    }
    
    private static HttpServletResponse getResponse() {
        return null; // Simulated, but method extraction
    }
}