// A sensitive cookie name flows into a Cookie, its toString() is used in addHeader without httponly substring should be flagged as positive.
package scensct.var.pos;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class PosCase1_Var3 {
    public void test(HttpServletResponse response) {
        String sensitiveName = "sessionId";
        Cookie cookie = null;
        try {
            cookie = new Cookie(sensitiveName, "value");
            cookie.setPath("/");
        } finally {
            if (cookie != null) {
                response.addHeader("set-cookie", cookie.toString()); // [REPORTED LINE]
            }
        }
    }
}