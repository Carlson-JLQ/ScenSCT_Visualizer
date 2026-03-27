// UUID from insecure random data has toString() called and the string flows into a SetCookieValue sink should be flagged as insecure randomness usage.
package scensct.var.pos;

import java.util.Random;
import java.util.UUID;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class PosCase7_Var4 {
    public static void main(String[] args) {
        // Variant 4: Loop-based generation and deferred sink
        Random r = new Random();
        long[] bits = new long[2];
        for (int i = 0; i < bits.length; i++) {
            bits[i] = r.nextLong();
        }
        UUID uid = new UUID(bits[0], bits[1]);
        String str = uid.toString();
        
        HttpServletResponse response = null;
        boolean flag = false;
        while (!flag) {
            // sink inside loop that executes once
            Cookie cookie = new Cookie("sessionId", str); // [REPORTED LINE]
            response.addCookie(cookie);
            flag = true;
        }
    }
}