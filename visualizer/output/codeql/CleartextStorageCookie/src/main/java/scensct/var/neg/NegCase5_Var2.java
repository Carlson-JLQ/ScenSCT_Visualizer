// Sensitive data flows into the second argument of a javax.servlet.http.Cookie constructor and a method named "addCookie" is called but not from HttpServletResponse should not be flagged as storing sensitive data in a cleartext cookie.
package scensct.var.neg;

import javax.servlet.http.Cookie;

public class NegCase5_Var2 {
    public void method(String sensitiveData) {
        // Variant 2: Control-flow restructuring with try-finally
        Cookie cookie = null;
        try {
            cookie = new Cookie("user", sensitiveData);
        } finally {
            CustomResponse cr = new CustomResponse();
            cr.addCookie(cookie);
        }
    }
    
    static class CustomResponse {
        public void addCookie(Cookie cookie) {
            // placeholder
        }
    }
}