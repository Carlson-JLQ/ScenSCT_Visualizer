// Sensitive cookie name with only addCookie calls having setMaxAge(0) should not be flagged.
package scensct.core.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class NegCase6 {
    public void setCookie(HttpServletResponse response) {
        String name = "key"; // Sensitive name
        Cookie cookie = new Cookie(name, "value");
        cookie.setMaxAge(0); // MaxAge zero (session cookie), no HttpOnly but scenario allows
        response.addCookie(cookie); // Sink call
        // No addHeader or setHeader calls present
    }
}