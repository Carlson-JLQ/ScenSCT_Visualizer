// A sensitive cookie name flows into a Cookie, its toString() is used in addHeader without httponly substring should be flagged as positive.
package scensct.var.pos;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class PosCase1_Var1 {
    public void test(HttpServletResponse resp) {
        String cookieName = "sessionId";
        Cookie c = new Cookie(cookieName, "data");
        c.setPath("/");
        String cookieString = c.toString();
        resp.addHeader("set-cookie", cookieString); // [REPORTED LINE]
    }
}