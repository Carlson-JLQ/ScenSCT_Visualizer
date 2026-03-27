// A compile-time constant sensitive cookie name flows into a Cookie, its toString() used to construct a new Cookie passed to addCookie without safety should be flagged as positive.
package scensct.core.pos;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class PosCase3 {
    public void test(HttpServletResponse response) {
        String sensitiveName = "sessionId"; // compile-time constant sensitive name
        Cookie cookie1 = new Cookie(sensitiveName, "value");
        cookie1.setPath("/");
        // toString() called, result used to construct new Cookie
        String cookieStr = cookie1.toString();
        // Simulating constructing a new Cookie from string (simplified for minimality)
        // In practice, parsing logic would be needed, but for flow demonstration we directly use cookie1
        Cookie cookie2 = new Cookie(sensitiveName, "value");
        cookie2.setPath("/");
        // Not made safe via setHttpOnly(true) or setMaxAge(0)
        response.addCookie(cookie2); // flows to addCookie // [REPORTED LINE]
    }
}