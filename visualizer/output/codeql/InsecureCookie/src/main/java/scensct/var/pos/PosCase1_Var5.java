// Adding a cookie without setting secure flag should be flagged as insecure.
package scensct.var.pos;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class PosCase1_Var5 {
    // Variant 5: Inline cookie creation inside addCookie argument, with extra unrelated statements
    public void insecureCookie(HttpServletResponse response) {
        String cookieName = "test";
        String cookieValue = "data";
        // No secure flag set
        response.addCookie(new Cookie(cookieName, cookieValue)); // [REPORTED LINE]
        System.out.println("Cookie added");
    }
}