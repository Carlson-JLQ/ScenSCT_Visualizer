// Sensitive cookie name with addCookie calls having setHttpOnly(true) should not be flagged.
package scensct.core.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class NegCase5 {
    public void setCookie(HttpServletResponse response) {
        String name = "credential"; // Sensitive name
        Cookie cookie = new Cookie(name, "value");
        cookie.setHttpOnly(true); // HttpOnly flag set
        response.addCookie(cookie); // Sink call with HttpOnly protection
    }
}