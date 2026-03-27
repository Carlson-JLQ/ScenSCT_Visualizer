// A sensitive cookie name flows into a Cookie, its toString() is used in addHeader without httponly substring should be flagged as positive.
package scensct.var.pos;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class PosCase1_Var5 {
    public void test(HttpServletResponse response) {
        String sensitiveName = "sessionId";
        Cookie cookie = new Cookie(sensitiveName, "value");
        cookie.setPath("/");
        // Using setHeader instead of addHeader, still without httponly
        response.setHeader("set-cookie", cookie.toString()); // [REPORTED LINE]
    }
}