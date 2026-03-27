// A compile-time constant sensitive cookie name passed to Cookie constructor flows to addHeader without httponly should be flagged as positive.
package scensct.var.pos;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class PosCase2_Var1 {
    public void test(HttpServletResponse response) {
        // Variant 1: Lexical refactoring - rename variables and use string concatenation
        final String cookieName = "authToken";
        Cookie sensitiveCookie = new Cookie(cookieName, "value");
        sensitiveCookie.setPath("/");
        String headerValue = sensitiveCookie.toString();
        response.addHeader("set-cookie", headerValue); // still no httponly // [REPORTED LINE]
    }
}