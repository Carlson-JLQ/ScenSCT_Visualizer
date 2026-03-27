// Sensitive data flows into the second argument of a javax.servlet.http.Cookie constructor and an addCookie call from HttpServletResponse is the store but a different cookie is passed should not be flagged as storing sensitive data in a cleartext cookie.
package scensct.var.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class NegCase7_Var3 {
    public void method(HttpServletResponse response, String sensitiveData) {
        // Variant 3: Control‑flow restructuring with a trivially true condition
        Cookie sensitiveCookie = null;
        if (true) {
            sensitiveCookie = new Cookie("name", sensitiveData);
        }
        Cookie otherCookie = new Cookie("other", "nonSensitive");
        response.addCookie(otherCookie);
    }
}