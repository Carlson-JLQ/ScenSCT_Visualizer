// Sensitive cookie name and sink exist but no taint flow between them should not be flagged.
package scensct.var.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class NegCase8_Var4 {
    public void setCookie(HttpServletResponse response) {
        // Use a switch to select cookie name, but sensitive name is in a dead branch
        String name;
        int mode = 2;
        switch (mode) {
            case 1:
                name = "auth"; // sensitive, but never reached
                break;
            default:
                name = "preferences";
        }
        Cookie cookie = new Cookie(name, "value");
        cookie.setHttpOnly(false);
        response.addCookie(cookie); // [REPORTED LINE]
    }
}