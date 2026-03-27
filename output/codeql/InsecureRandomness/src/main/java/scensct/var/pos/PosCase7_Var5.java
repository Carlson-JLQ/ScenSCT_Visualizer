// UUID from insecure random data has toString() called and the string flows into a SetCookieValue sink should be flagged as insecure randomness usage.
package scensct.var.pos;

import java.util.Random;
import java.util.UUID;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class PosCase7_Var5 {
    public static void main(String[] args) {
        // Variant 5: Inline the UUID construction and use a switch to obscure control flow
        Random insecure = new Random();
        String uuidStr = new UUID(insecure.nextLong(), insecure.nextLong()).toString();
        
        HttpServletResponse res = null;
        int dummy = 3;
        switch (dummy) {
            case 1:
                break;
            case 2:
                break;
            case 3: // this case matches
                Cookie c = new Cookie("sessionId", uuidStr); // [REPORTED LINE]
                res.addCookie(c);
                break;
            default:
                break;
        }
    }
}