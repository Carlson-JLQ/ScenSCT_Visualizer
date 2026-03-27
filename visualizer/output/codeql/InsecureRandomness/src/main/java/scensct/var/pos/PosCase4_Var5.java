// Insecure random data passed to UUID constructor and resulting UUID flows into a SetCookieValue sink should be flagged as insecure randomness usage.
package scensct.var.pos;

import java.util.Random;
import java.util.UUID;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class PosCase4_Var5 {
    public static void main(String[] args) {
        // Use a single Random instance but call nextLong twice
        Random src = new Random();
        UUID uuid = UUID.randomUUID(); // Secure UUID, but we will replace with insecure
        // Override with insecure bits
        long msb = src.nextLong();
        long lsb = src.nextLong();
        uuid = new UUID(msb, lsb); // Reassign
        HttpServletResponse response = null;
        // Loop that always executes once
        for (int i = 0; i < 1; i++) {
            if (response != null) {
                Cookie cookie = new Cookie("sessionId", uuid.toString()); // [REPORTED LINE]
                response.addCookie(cookie);
                break;
            }
        }
    }
}