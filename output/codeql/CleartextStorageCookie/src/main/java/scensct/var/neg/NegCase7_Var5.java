// Sensitive data flows into the second argument of a javax.servlet.http.Cookie constructor and an addCookie call from HttpServletResponse is the store but a different cookie is passed should not be flagged as storing sensitive data in a cleartext cookie.
package scensct.var.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class NegCase7_Var5 {
    public void method(HttpServletResponse response, String sensitiveData) {
        // Variant 5: Use StringBuilder for cookie value, swap creation order,
        // and introduce an alias for the non‑sensitive cookie.
        Cookie c = new Cookie("other", new StringBuilder().append("non").append("Sensitive").toString());
        response.addCookie(c);
        Cookie sensitiveCookie = new Cookie("name", sensitiveData);
    }
}