// Sensitive data flows into the second argument of a javax.servlet.http.Cookie constructor, an addCookie call from HttpServletResponse is the store, and the cookie instance is syntactically passed but dataflow path is broken should not be flagged as storing sensitive data in a cleartext cookie.
package scensct.core.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class NegCase8 {
    public void method(HttpServletResponse response, String sensitiveData) {
        // Scenario 8: Dataflow path from cookie instance to addCookie argument is broken due to reassignment
        Cookie cookie = new Cookie("name", sensitiveData);
        cookie = null; // Reassignment breaks the dataflow path
        response.addCookie(cookie); // cookie is null, so no sensitive data flows to addCookie
    }
}