// Sensitive cookie name with addCookie calls having setHttpOnly(true) should not be flagged.
package scensct.var.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class NegCase5_Var4 {
    // Variant 4: Wrap in try-catch-finally, ensuring setHttpOnly runs before sink
    public void setCookie(HttpServletResponse response) {
        String name = "credential";
        Cookie cookie = new Cookie(name, "value");
        try {
            cookie.setHttpOnly(true);
        } finally {
            // Ensure flag is set even if exception? Actually setHttpOnly won't throw.
            // But this structure tests control-flow sensitivity.
        }
        response.addCookie(cookie);
    }
}