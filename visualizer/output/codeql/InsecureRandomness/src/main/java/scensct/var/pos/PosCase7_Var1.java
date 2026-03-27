// UUID from insecure random data has toString() called and the string flows into a SetCookieValue sink should be flagged as insecure randomness usage.
package scensct.var.pos;

import java.util.Random;
import java.util.UUID;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class PosCase7_Var1 {
    public static void main(String[] args) {
        // Variant 1: Restructure with temporaries and ternary for response guard
        Random rng = new Random();
        long msb = rng.nextLong();
        long lsb = rng.nextLong();
        UUID id = new UUID(msb, lsb);
        String value = id.toString();
        
        HttpServletResponse resp = Math.random() > 0.5 ? null : null; // still null, but syntactically different
        if (resp == null) {
            // This branch is not taken, but the sink is still reachable in the other branch
            // We'll place the sink in the else branch to keep the same reachability condition
        } else {
            Cookie c = new Cookie("sessionId", value); // [REPORTED LINE]
            resp.addCookie(c);
        }
    }
}