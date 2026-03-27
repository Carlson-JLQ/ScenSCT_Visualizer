// Non-sensitive compile-time constant cookie names should not be flagged as missing HttpOnly.
package scensct.var.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class NegCase1_Var5 {
    public void setCookie(HttpServletResponse response) {
        // Variant 5: Combined lexical and control flow - loop that runs exactly once and uses a local variable for the flag
        String name = "preferences";
        for (int i = 0; i < 1; i++) {
            Cookie cookie = new Cookie(name, "value");
            boolean noHttpOnly = false;
            cookie.setHttpOnly(noHttpOnly);
            response.addCookie(cookie);
        }
    }
}