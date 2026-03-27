// Non-sensitive compile-time constant cookie names should not be flagged as missing HttpOnly.
package scensct.var.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class NegCase1_Var3 {
    public void setCookie(HttpServletResponse response) {
        // Variant 3: Intra-procedural control flow - use a conditional that always executes, but with a constant condition
        final boolean shouldSetCookie = true;
        if (shouldSetCookie) {
            Cookie cookie = new Cookie("preferences", "value");
            cookie.setHttpOnly(false);
            response.addCookie(cookie);
        }
        // No else branch, so the cookie is always set
    }
}