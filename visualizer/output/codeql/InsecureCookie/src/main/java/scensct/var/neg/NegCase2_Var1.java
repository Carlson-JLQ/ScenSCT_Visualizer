// A Java source file containing a method call where the method name is not "addCookie" OR the method's declaring type is not javax.servlet.http.HttpServletResponse or jakarta.servlet.http.HttpServletResponse should not be flagged as insecure cookie.
package scensct.var.neg;

import javax.servlet.http.Cookie;

public class NegCase2_Var1 {
    public void process(Object obj) {
        // Variant 1: Aliasing and control-flow restructuring
        javax.servlet.http.HttpServletResponse resp = null;
        if (obj instanceof javax.servlet.http.HttpServletResponse) {
            resp = (javax.servlet.http.HttpServletResponse) obj;
        }
        // Use alias in a loop to obscure the call
        for (int i = 0; i < 1; i++) {
            if (resp != null) {
                resp.setHeader("Set-Cookie", "session=xyz; Secure"); // Still not addCookie
            }
        }
        
        // Create cookie with secure flag via builder-like pattern
        Cookie cookie = createSecureCookie("test", "value");
        // Call addCookie on a different type via a temporary variable
        AnotherClass another = getAnother();
        another.addCookie(cookie); // Type is AnotherClass, not HttpServletResponse
    }
    
    private Cookie createSecureCookie(String name, String val) {
        Cookie c = new Cookie(name, val);
        c.setSecure(true);
        return c;
    }
    
    private AnotherClass getAnother() {
        return new AnotherClass();
    }
    
    static class AnotherClass {
        public void addCookie(Cookie cookie) {
            // Custom implementation
        }
    }
}