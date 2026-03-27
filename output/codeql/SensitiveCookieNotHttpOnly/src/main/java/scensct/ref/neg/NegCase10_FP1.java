// Sensitive cookie name flows to sink lacking HttpOnly with specific flow steps should not be flagged.
package scensct.ref.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class NegCase10_FP1 {
    public void setCookie(HttpServletResponse response) {
        String sensitiveName = "sessionId";
        // Flow involves argument to Cookie constructor but not the call itself
        String[] args = {sensitiveName, "value"};
        Cookie cookie = new Cookie(args[0], args[1]); // Constructor call
        // Flow involves qualifier of toString method but not the call itself
        Cookie qualifier = cookie; // Qualifier stored
        cookie.setHttpOnly(false); // No HttpOnly flag
        response.addCookie(cookie); // Sink call // [REPORTED LINE]
        // No NewCookie with HttpOnly true
    }
}