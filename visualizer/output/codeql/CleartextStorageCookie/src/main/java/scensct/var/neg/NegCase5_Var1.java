// Sensitive data flows into the second argument of a javax.servlet.http.Cookie constructor and a method named "addCookie" is called but not from HttpServletResponse should not be flagged as storing sensitive data in a cleartext cookie.
package scensct.var.neg;

import javax.servlet.http.Cookie;

public class NegCase5_Var1 {
    public void method(String secret) {
        // Variant 1: Lexical renaming and temporary variable
        Cookie c = new Cookie("sessionId", secret);
        CustomResponse resp = new CustomResponse();
        if (resp != null) {
            resp.addCookie(c);
        }
    }
    
    static class CustomResponse {
        public void addCookie(Cookie cookie) {
            // custom logic
        }
    }
}