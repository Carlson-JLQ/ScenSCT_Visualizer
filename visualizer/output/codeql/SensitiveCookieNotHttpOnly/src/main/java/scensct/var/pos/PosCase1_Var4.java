// A sensitive cookie name flows into a Cookie, its toString() is used in addHeader without httponly substring should be flagged as positive.
package scensct.var.pos;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class PosCase1_Var4 {
    public void test(HttpServletResponse response) {
        String name = "sessionId";
        Cookie cookie = new Cookie(name, "val");
        cookie.setPath("/");
        if (response != null) {
            response.addHeader("set-cookie", cookie.toString()); // [REPORTED LINE]
        }
    }
}