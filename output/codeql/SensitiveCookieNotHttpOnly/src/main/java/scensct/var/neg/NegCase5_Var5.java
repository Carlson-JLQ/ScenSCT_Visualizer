// Sensitive cookie name with addCookie calls having setHttpOnly(true) should not be flagged.
package scensct.var.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class NegCase5_Var5 {
    // Variant 5: Use a builder-like pattern via method chaining (simulated within same method)
    public void setCookie(HttpServletResponse response) {
        Cookie cookie = createCookieWithFlag("credential", "value");
        response.addCookie(cookie);
    }

    private Cookie createCookieWithFlag(String n, String v) {
        Cookie c = new Cookie(n, v);
        c.setHttpOnly(true);
        return c;
    }
}