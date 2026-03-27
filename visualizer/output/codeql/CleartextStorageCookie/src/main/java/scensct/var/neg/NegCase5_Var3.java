// Sensitive data flows into the second argument of a javax.servlet.http.Cookie constructor and a method named "addCookie" is called but not from HttpServletResponse should not be flagged as storing sensitive data in a cleartext cookie.
package scensct.var.neg;

import javax.servlet.http.Cookie;

public class NegCase5_Var3 {
    public void method(String input) {
        // Variant 3: Extract cookie creation to helper method
        Cookie cookie = makeCookie("token", input);
        CustomResponse custom = new CustomResponse();
        custom.addCookie(cookie);
    }
    
    private Cookie makeCookie(String name, String value) {
        return new Cookie(name, value);
    }
    
    static class CustomResponse {
        public void addCookie(Cookie cookie) {
            // custom
        }
    }
}