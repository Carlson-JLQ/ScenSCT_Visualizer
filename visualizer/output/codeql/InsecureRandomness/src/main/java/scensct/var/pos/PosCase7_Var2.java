// UUID from insecure random data has toString() called and the string flows into a SetCookieValue sink should be flagged as insecure randomness usage.
package scensct.var.pos;

import java.util.Random;
import java.util.UUID;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class PosCase7_Var2 {
    // Helper method to produce insecure UUID string
    private static String makeInsecureUUIDString(Random rand) {
        long part1 = rand.nextLong();
        long part2 = rand.nextLong();
        UUID u = new UUID(part1, part2);
        return u.toString();
    }
    
    // Helper method to set cookie if response exists
    private static void setCookieIfPossible(HttpServletResponse res, String val) {
        if (res != null) {
            Cookie cookie = new Cookie("sessionId", val); // [REPORTED LINE]
            res.addCookie(cookie);
        }
    }
    
    public static void main(String[] args) {
        // Variant 2: Inter-procedural split of source and sink
        Random insecure = new Random();
        String uuidStr = makeInsecureUUIDString(insecure);
        HttpServletResponse response = null;
        setCookieIfPossible(response, uuidStr);
    }
}