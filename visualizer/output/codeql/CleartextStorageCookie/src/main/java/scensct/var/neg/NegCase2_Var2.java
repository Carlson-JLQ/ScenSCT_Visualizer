// Sensitive data flows into an argument of a javax.servlet.http.Cookie constructor that is not the second argument (the value) should not be flagged as storing sensitive data in a cleartext cookie.
package scensct.var.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class NegCase2_Var2 {
    // Variant 2: Control-flow restructuring with conditional that always passes sensitive data to name
    public void method(HttpServletResponse response, String sensitiveData) {
        Cookie cookie;
        if (System.currentTimeMillis() > 0) { // Always true
            cookie = new Cookie(sensitiveData, "staticValue");
        } else {
            cookie = new Cookie("defaultName", "defaultValue");
        }
        response.addCookie(cookie);
    }
}