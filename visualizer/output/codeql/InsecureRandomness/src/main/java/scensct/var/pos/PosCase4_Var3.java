// Insecure random data passed to UUID constructor and resulting UUID flows into a SetCookieValue sink should be flagged as insecure randomness usage.
package scensct.var.pos;

import java.util.Random;
import java.util.UUID;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class PosCase4_Var3 {
    public static void main(String[] args) {
        Random insecureRand = new Random();
        // Store bits in array and then use
        long[] bits = new long[2];
        bits[0] = insecureRand.nextLong();
        bits[1] = insecureRand.nextLong();
        UUID uuid = createUUID(bits[0], bits[1]);
        HttpServletResponse response = null;
        // Inverted condition with early return
        if (response == null) {
            return;
        }
        Cookie cookie = new Cookie("sessionId", uuid.toString()); // [REPORTED LINE]
        response.addCookie(cookie);
    }
    
    private static UUID createUUID(long most, long least) {
        return new UUID(most, least);
    }
}