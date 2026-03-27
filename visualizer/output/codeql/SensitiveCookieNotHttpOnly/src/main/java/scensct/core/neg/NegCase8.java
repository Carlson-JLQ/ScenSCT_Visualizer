// Sensitive cookie name and sink exist but no taint flow between them should not be flagged.
package scensct.core.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class NegCase8 {
    public void setCookie(HttpServletResponse response) {
        String sensitiveName = "auth"; // Sensitive name
        Cookie cookie = new Cookie("preferences", "value"); // Non-sensitive name used
        cookie.setHttpOnly(false); // No HttpOnly flag
        response.addCookie(cookie); // Sink call with non-sensitive name
        // sensitiveName never flows to the sink
    }
}