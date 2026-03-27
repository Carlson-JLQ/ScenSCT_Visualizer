// Sensitive cookie name and sink exist but no taint flow between them should not be flagged.
package scensct.var.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class NegCase8_Var5 {
    public void setCookie(HttpServletResponse response) {
        // Split cookie creation across multiple steps with temporary variables
        String sensitive = "auth".toUpperCase(); // still sensitive pattern
        String actualName = "preferences";
        String value = "value";
        Cookie c = new Cookie(actualName, value);
        c.setHttpOnly(false);
        // sensitive variable is passed to a dummy method that does nothing
        log(sensitive);
        response.addCookie(c);
    }

    private void log(String msg) {
        // dummy
    }
}