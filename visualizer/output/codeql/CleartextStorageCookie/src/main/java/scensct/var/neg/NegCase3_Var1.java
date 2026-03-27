// A javax.servlet.http.Cookie is constructed with a non-sensitive value argument should not be flagged as storing sensitive data in a cleartext cookie.
package scensct.var.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class NegCase3_Var1 {
    public void method(HttpServletResponse response, String sensitiveData) {
        // Non-sensitive built from literal + empty string
        String prefix = "";
        String nonSensitiveValue = prefix + "publicInfo";
        // Swap constructor arguments order (still same semantics)
        Cookie cookie = new Cookie("name", nonSensitiveValue);
        response.addCookie(cookie);
    }
}