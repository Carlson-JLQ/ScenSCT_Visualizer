// Sensitive data flows into an argument of a javax.servlet.http.Cookie constructor that is not the second argument (the value) should not be flagged as storing sensitive data in a cleartext cookie.
package scensct.var.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class NegCase2_Var3 {
    // Variant 3: Extract cookie creation to a helper method, preserving flow to name
    public void method(HttpServletResponse response, String sensitiveData) {
        Cookie cookie = createCookieWithName(sensitiveData);
        response.addCookie(cookie);
    }

    private Cookie createCookieWithName(String name) {
        return new Cookie(name, "nonSensitive");
    }
}