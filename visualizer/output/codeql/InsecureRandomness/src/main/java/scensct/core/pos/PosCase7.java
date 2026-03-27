// UUID from insecure random data has toString() called and the string flows into a SetCookieValue sink should be flagged as insecure randomness usage.
package scensct.core.pos;

import java.util.Random;
import java.util.UUID;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class PosCase7 {
    public static void main(String[] args) {
        Random insecureRand = new Random(); // Insecure random source
        long mostSigBits = insecureRand.nextLong();
        long leastSigBits = insecureRand.nextLong();
        UUID uuid = new UUID(mostSigBits, leastSigBits); // UUID constructed from insecure data
        String uuidStr = uuid.toString(); // toString() called
        HttpServletResponse response = null; // Simulated response
        if (response != null) {
            Cookie cookie = new Cookie("sessionId", uuidStr); // [REPORTED LINE]
            response.addCookie(cookie); // SetCookieValue sink
        }
    }
}