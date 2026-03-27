// Sensitive data flows into the second argument of a javax.servlet.http.Cookie constructor and an addCookie from HttpServletResponse is called but not as the store node in the dataflow should not be flagged as storing sensitive data in a cleartext cookie.
package scensct.var.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class NegCase6_Var1 {
    public void method(HttpServletResponse response, String sensitiveData) {
        // Variant 1: Introduce a temporary variable for the cookie value
        String cookieValue = sensitiveData;
        Cookie cookie = new Cookie("name", cookieValue);
        response.addCookie(cookie);
    }
}