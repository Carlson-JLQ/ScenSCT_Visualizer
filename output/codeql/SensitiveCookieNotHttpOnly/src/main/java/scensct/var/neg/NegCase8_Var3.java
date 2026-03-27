// Sensitive cookie name and sink exist but no taint flow between them should not be flagged.
package scensct.var.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class NegCase8_Var3 {
    public void setCookie(HttpServletResponse response) {
        // Reorder and add a try-finally block that does not affect flow
        String secret = "auth";
        try {
            Cookie cookie = new Cookie("preferences", "value");
            cookie.setHttpOnly(false);
            response.addCookie(cookie);
        } finally {
            // cleanup unrelated to cookie
            System.gc();
        }
        // secret not involved
    }
}