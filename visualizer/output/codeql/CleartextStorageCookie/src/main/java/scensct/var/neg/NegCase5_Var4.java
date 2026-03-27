// Sensitive data flows into the second argument of a javax.servlet.http.Cookie constructor and a method named "addCookie" is called but not from HttpServletResponse should not be flagged as storing sensitive data in a cleartext cookie.
package scensct.var.neg;

import javax.servlet.http.Cookie;

public class NegCase5_Var4 {
    public void method(String sensitiveData) {
        // Variant 4: Inline CustomResponse as anonymous class
        Object responder = new Object() {
            void addCookie(Cookie c) {}
        };
        Cookie cookie = new Cookie("id", sensitiveData);
        // Note: This won't compile as-is because addCookie isn't accessible.
        // Instead, we keep the original class but change instantiation style.
        CustomResponse cr = new CustomResponse() {
            @Override
            public void addCookie(Cookie cookie) {
                super.addCookie(cookie);
            }
        };
        cr.addCookie(cookie);
    }
    
    static class CustomResponse {
        public void addCookie(Cookie cookie) {
            // custom
        }
    }
}