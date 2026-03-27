// Sensitive cookie name flows to sink lacking HttpOnly with specific flow steps should not be flagged.
package scensct.ref.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class NegCase9_FP1 {
    public void setCookie(HttpServletResponse response) {
        String sensitiveName = "token";
        // Flow involves argument to Cookie constructor but not the call itself
        String[] args = {sensitiveName, "value"}; // Arguments stored
        Cookie cookie = new Cookie(args[0], args[1]); // Constructor call with arguments
        cookie.setHttpOnly(false); // No HttpOnly flag
        response.addCookie(cookie); // Sink call // [REPORTED LINE]
        // No NewCookie with HttpOnly true, no toString qualifier involved
    }
}