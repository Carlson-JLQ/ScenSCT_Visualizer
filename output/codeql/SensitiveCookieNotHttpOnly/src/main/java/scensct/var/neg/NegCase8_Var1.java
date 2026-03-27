// Sensitive cookie name and sink exist but no taint flow between them should not be flagged.
package scensct.var.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class NegCase8_Var1 {
    public void setCookie(HttpServletResponse response) {
        // Move sensitive name declaration earlier, add unrelated computation
        final String token = "auth";
        String cookieName = "preferences";
        if (response != null) {
            Cookie c = new Cookie(cookieName, "value");
            c.setHttpOnly(false);
            response.addCookie(c);
        }
        // token never used in cookie creation
    }
}