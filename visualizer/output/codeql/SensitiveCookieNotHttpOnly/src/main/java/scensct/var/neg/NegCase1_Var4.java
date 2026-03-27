// Non-sensitive compile-time constant cookie names should not be flagged as missing HttpOnly.
package scensct.var.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class NegCase1_Var4 {
    // Variant 4: Idiomatic variation - use a static final constant for the cookie name, and setHttpOnly with explicit false
    private static final String COOKIE_NAME = "preferences";

    public void setCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie(COOKIE_NAME, "value");
        // Explicitly setting false to mimic missing HttpOnly
        cookie.setHttpOnly(Boolean.FALSE);
        response.addCookie(cookie);
    }
}