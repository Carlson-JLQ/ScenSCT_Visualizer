// Sensitive cookie name and sink exist but no taint flow between them should not be flagged.
package scensct.var.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class NegCase8_Var2 {
    private static final String SENSITIVE = "auth";

    public void setCookie(HttpServletResponse response) {
        // Sensitive name is a field, but cookie name is literal
        Cookie cookie = createCookie("preferences");
        cookie.setHttpOnly(false);
        response.addCookie(cookie);
    }

    private Cookie createCookie(String name) {
        return new Cookie(name, "value");
    }
}