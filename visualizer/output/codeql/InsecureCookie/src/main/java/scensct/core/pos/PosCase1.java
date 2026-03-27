// Adding a cookie without setting secure flag should be flagged as insecure.
package scensct.core.pos;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class PosCase1 {
    public void insecureCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("sessionId", "abc123");
        // Cookie created without setting secure flag
        response.addCookie(cookie); // [REPORTED LINE]
    }
}