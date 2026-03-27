// Sensitive data flows into the second argument of a javax.servlet.http.Cookie constructor and a method named "addCookie" is called but not from HttpServletResponse should not be flagged as storing sensitive data in a cleartext cookie.
package scensct.var.neg;

import javax.servlet.http.Cookie;

public class NegCase5_Var5 {
    // Variant 5: Inter-procedural - move entire scenario to instance method of CustomResponse
    public void method(String sensitiveData) {
        CustomResponse custom = new CustomResponse();
        custom.handleCookie(sensitiveData);
    }
    
    static class CustomResponse {
        public void addCookie(Cookie cookie) {
            // custom
        }
        
        public void handleCookie(String value) {
            Cookie c = new Cookie("key", value);
            this.addCookie(c);
        }
    }
}