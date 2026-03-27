// Sensitive data flows into an argument of a javax.servlet.http.Cookie constructor that is not the second argument (the value) should not be flagged as storing sensitive data in a cleartext cookie.
package scensct.var.neg;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class NegCase2_Var1 {
    // Variant 1: Lexical refactoring with temporary variable and renamed parameters
    public void method(HttpServletResponse resp, String secret) {
        String cookieName = secret; // Sensitive data aliased
        Cookie c = new Cookie(cookieName, "sessionId");
        resp.addCookie(c);
    }
}