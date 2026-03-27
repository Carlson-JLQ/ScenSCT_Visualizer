// A Java source file containing a method call where the method name is not "addCookie" OR the method's declaring type is not javax.servlet.http.HttpServletResponse or jakarta.servlet.http.HttpServletResponse should not be flagged as insecure cookie.
package scensct.var.neg;

import javax.servlet.http.Cookie;

public class NegCase2_Var3 {
    // Variant 3: Lexical variation and expression reshaping
    public void process(Object potentialResponse) {
        // Use ternary for assignment
        javax.servlet.http.HttpServletResponse response = 
            potentialResponse instanceof javax.servlet.http.HttpServletResponse 
                ? (javax.servlet.http.HttpServletResponse) potentialResponse 
                : null;
        if (response != null) {
            // Chain method calls, but still not addCookie
            response.setHeader("Cookie-Setting", "auth=token; Secure=true");
        }
        
        // Cookie creation with secure flag set via method reference (lambda-style)
        java.util.function.Consumer<Cookie> secureSetter = c -> c.setSecure(true);
        Cookie myCookie = new Cookie("sessionId", "abcdef");
        secureSetter.accept(myCookie);
        
        // Call addCookie on a different type via static method
        AnotherClass.addCookieStatic(myCookie); // Static method, type is AnotherClass
    }
    
    static class AnotherClass {
        public static void addCookieStatic(Cookie cookie) {
            // Static custom implementation
        }
        public void addCookie(Cookie cookie) {}
    }
}