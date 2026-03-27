// Non-sensitive compile-time constant cookie names should not be flagged as missing HttpOnly.
package scensct.var.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class NegCase1_Var2 {
    // Variant 2: Inter-procedural refactoring - extract cookie configuration into a helper method
    public void setCookie(HttpServletResponse response) {
        Cookie cookie = createCookie("preferences", "value");
        configureCookie(cookie, false);
        response.addCookie(cookie);
    }

    private Cookie createCookie(String name, String value) {
        return new Cookie(name, value);
    }

    private void configureCookie(Cookie cookie, boolean httpOnly) {
        cookie.setHttpOnly(httpOnly);
    }
}