// Non-sensitive compile-time constant cookie names should not be flagged as missing HttpOnly.
package scensct.core.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class NegCase1 {
    public void setCookie(HttpServletResponse response) {
        // Non-sensitive constant name "preferences" does not match sensitive patterns
        Cookie cookie = new Cookie("preferences", "value");
        cookie.setHttpOnly(false); // No HttpOnly flag
        response.addCookie(cookie); // Sink call with non-sensitive name
    }
}