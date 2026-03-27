// A compile-time constant sensitive cookie name flows into a Cookie, its toString() used to construct a new Cookie passed to addCookie without safety should be flagged as positive.
package scensct.var.pos;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class PosCase3_Var3 {
    // Variant 3: Wrap cookie setting in a try-finally block, with the addCookie in finally
    public void test(HttpServletResponse response) {
        String sensitiveName = "sessionId";
        Cookie cookie = new Cookie(sensitiveName, "value");
        cookie.setPath("/");
        try {
            // some dummy operation
            int x = 1;
        } finally {
            // Ensure cookie is added even if an exception (none here) occurs
            response.addCookie(cookie); // [REPORTED LINE]
        }
    }
}