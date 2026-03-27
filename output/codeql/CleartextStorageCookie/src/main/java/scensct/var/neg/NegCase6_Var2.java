// Sensitive data flows into the second argument of a javax.servlet.http.Cookie constructor and an addCookie from HttpServletResponse is called but not as the store node in the dataflow should not be flagged as storing sensitive data in a cleartext cookie.
package scensct.var.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class NegCase6_Var2 {
    public void method(HttpServletResponse response, String sensitiveData) {
        // Variant 2: Restructure with an if-else that doesn't affect the flow
        Cookie cookie;
        if (response != null) {
            cookie = new Cookie("name", sensitiveData);
        } else {
            cookie = new Cookie("name", "default");
        }
        response.addCookie(cookie);
    }
}