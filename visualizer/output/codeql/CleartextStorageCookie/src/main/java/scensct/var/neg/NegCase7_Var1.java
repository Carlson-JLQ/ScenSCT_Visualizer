// Sensitive data flows into the second argument of a javax.servlet.http.Cookie constructor and an addCookie call from HttpServletResponse is the store but a different cookie is passed should not be flagged as storing sensitive data in a cleartext cookie.
package scensct.var.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class NegCase7_Var1 {
    public void method(HttpServletResponse response, String sensitiveData) {
        // Variant 1: Reorder statements, use temporary for sensitive cookie value
        String secret = sensitiveData;
        Cookie other = new Cookie("other", "nonSensitive");
        response.addCookie(other);
        Cookie sensitiveCookie = new Cookie("name", secret);
    }
}