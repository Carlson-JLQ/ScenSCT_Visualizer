// Adding a cookie without setting secure flag should be flagged as insecure.
package scensct.var.pos;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class PosCase1_Var3 {
    // Variant 3: Control flow with condition that always passes, temporary variable
    public void insecureCookie(HttpServletResponse response) {
        boolean shouldAdd = true;
        Cookie cookie = null;
        if (shouldAdd) {
            cookie = new Cookie("session", "123abc");
            // secure flag not set
        }
        if (cookie != null) {
            response.addCookie(cookie); // [REPORTED LINE]
        }
    }
}