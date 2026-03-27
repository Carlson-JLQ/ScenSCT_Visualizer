// Non-sensitive compile-time constant cookie names should not be flagged as missing HttpOnly.
package scensct.var.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class NegCase1_Var1 {
    public void setCookie(HttpServletResponse response) {
        // Variant 1: Lexical refactoring - split cookie creation and setting into separate steps with a temporary variable
        final String cookieName = "preferences";
        Cookie c = new Cookie(cookieName, "value");
        boolean httpOnlyFlag = false;
        c.setHttpOnly(httpOnlyFlag);
        response.addCookie(c);
    }
}