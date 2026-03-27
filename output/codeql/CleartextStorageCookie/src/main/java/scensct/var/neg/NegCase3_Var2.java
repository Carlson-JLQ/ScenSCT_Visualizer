// A javax.servlet.http.Cookie is constructed with a non-sensitive value argument should not be flagged as storing sensitive data in a cleartext cookie.
package scensct.var.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class NegCase3_Var2 {
    public void method(HttpServletResponse response, String sensitiveData) {
        String nonSensitiveValue;
        if (response != null) { // always true given typical usage
            nonSensitiveValue = "publicInfo";
        } else {
            nonSensitiveValue = "fallback"; // unreachable
        }
        Cookie cookie = new Cookie("name", nonSensitiveValue);
        response.addCookie(cookie);
    }
}