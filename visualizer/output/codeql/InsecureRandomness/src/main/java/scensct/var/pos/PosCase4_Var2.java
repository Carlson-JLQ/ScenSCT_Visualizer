// Insecure random data passed to UUID constructor and resulting UUID flows into a SetCookieValue sink should be flagged as insecure randomness usage.
package scensct.var.pos;

import java.util.Random;
import java.util.UUID;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class PosCase4_Var2 {
    public static void main(String[] args) {
        // Using Math.random() as another insecure source
        long mostSigBits = (long) (Math.random() * Long.MAX_VALUE);
        Random insecureRand = new Random();
        long leastSigBits = insecureRand.nextLong();
        UUID uuid = new UUID(mostSigBits, leastSigBits);
        HttpServletResponse response = simulateResponse();
        try {
            if (response != null) {
                Cookie cookie = new Cookie("sessionId", uuid.toString()); // [REPORTED LINE]
                response.addCookie(cookie);
            }
        } catch (Exception e) {
            // Ignore
        }
    }
    
    private static HttpServletResponse simulateResponse() {
        return null;
    }
}