// Sensitive data flows into the second argument of a javax.servlet.http.Cookie constructor and an addCookie from HttpServletResponse is called but not as the store node in the dataflow should not be flagged as storing sensitive data in a cleartext cookie.
package scensct.var.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class NegCase6_Var3 {
    // Variant 3: Extract cookie creation into a helper method, but keep store node in constructor
    private Cookie createCookie(String name, String value) {
        return new Cookie(name, value);
    }

    public void method(HttpServletResponse response, String sensitiveData) {
        Cookie cookie = createCookie("name", sensitiveData);
        response.addCookie(cookie);
    }
}