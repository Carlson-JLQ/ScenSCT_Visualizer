// UUID from insecure random data has toString() called and the string flows into a SetCookieValue sink should be flagged as insecure randomness usage.
package scensct.var.pos;

import java.util.Random;
import java.util.UUID;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class PosCase7_Var3 {
    public static void main(String[] args) {
        // Variant 3: Use Math.random() to derive insecure bits (still insecure source)
        Random insecureRand = new Random();
        // Simulate getting bits from Math.random() * Long.MAX_VALUE
        long mostSig = (long) (Math.random() * Long.MAX_VALUE);
        long leastSig = insecureRand.nextLong(); // still insecure
        
        UUID uuid = UUID.fromString(new UUID(mostSig, leastSig).toString()); // roundabout construction
        String cookieValue = uuid.toString();
        
        HttpServletResponse resp = null;
        try {
            if (resp == null) throw new RuntimeException("simulated");
        } catch (RuntimeException e) {
            // sink placed in catch block, but still reachable
            Cookie c = new Cookie("sessionId", cookieValue);
            resp.addCookie(c); // resp is null, but flow exists
        }
    }
}