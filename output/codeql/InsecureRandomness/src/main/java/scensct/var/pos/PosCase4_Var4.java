// Insecure random data passed to UUID constructor and resulting UUID flows into a SetCookieValue sink should be flagged as insecure randomness usage.
package scensct.var.pos;

import java.util.Random;
import java.util.UUID;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class PosCase4_Var4 {
    public static void main(String[] args) {
        Random insecureRand = new Random();
        // Generate bits via helper method
        long mostSigBits = getRandomLong(insecureRand);
        long leastSigBits = getRandomLong(insecureRand);
        UUID uuid = new UUID(mostSigBits, leastSigBits);
        // Response obtained via a method that could return non-null in other contexts
        HttpServletResponse response = getHttpResponse();
        if (response != null) {
            setCookieWithUUID(response, uuid);
        }
    }
    
    private static long getRandomLong(Random r) {
        return r.nextLong();
    }
    
    private static HttpServletResponse getHttpResponse() {
        return null;
    }
    
    private static void setCookieWithUUID(HttpServletResponse resp, UUID uuid) {
        Cookie cookie = new Cookie("sessionId", uuid.toString()); // [REPORTED LINE]
        resp.addCookie(cookie);
    }
}