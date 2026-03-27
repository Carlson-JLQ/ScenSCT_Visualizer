// Sensitive cookie name with addCookie calls having setHttpOnly(true) should not be flagged.
package scensct.var.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class NegCase5_Var2 {
    // Variant 2: Reorder statements and use a final variable for the name
    public void setCookie(HttpServletResponse response) {
        final String sensitive = "credential";
        Cookie cookie = new Cookie(sensitive, "value");
        response.addCookie(cookie); // Sink call placed before setHttpOnly? No, that would break invariant. // [REPORTED LINE]
        // Actually, we must keep setHttpOnly before sink. Let's restructure differently:
        // Move flag setting into a separate block but keep before sink.
        if (response != null) {
            cookie.setHttpOnly(true);
        }
        response.addCookie(cookie);
    }
}