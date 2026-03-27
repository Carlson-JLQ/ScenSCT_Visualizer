// Sensitive data flows into the second argument of a javax.servlet.http.Cookie constructor, an addCookie call from HttpServletResponse is the store, and the cookie instance is syntactically passed but dataflow path is broken should not be flagged as storing sensitive data in a cleartext cookie.
package scensct.var.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class NegCase8_Var4 {
    public void method(HttpServletResponse response, String sensitiveData) {
        Cookie cookie = new Cookie("name", sensitiveData);
        try {
            Integer.parseInt("123"); // harmless
            cookie = null;
        } catch (NumberFormatException e) {
            // not taken
        }
        response.addCookie(cookie);
    }
}