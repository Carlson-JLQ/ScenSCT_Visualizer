// A Java source file containing a method call where the method name is not "addCookie" OR the method's declaring type is not javax.servlet.http.HttpServletResponse or jakarta.servlet.http.HttpServletResponse should not be flagged as insecure cookie.
package scensct.core.neg;

import javax.servlet.http.Cookie;

public class NegCase2 {
    public void process(Object obj) {
        // Method name is not addCookie (setCookie) and/or type is not HttpServletResponse
        if (obj instanceof javax.servlet.http.HttpServletResponse) {
            javax.servlet.http.HttpServletResponse resp = (javax.servlet.http.HttpServletResponse) obj;
            resp.setHeader("Set-Cookie", "session=abc"); // Different method, not addCookie
        }
        // Alternative: addCookie called on a different type (not HttpServletResponse)
        Cookie cookie = new Cookie("test", "value");
        cookie.setSecure(true);
        // cookie.addCookie(cookie); // This method doesn't exist on Cookie, so using a placeholder
        // Instead, using a custom class with addCookie method
        AnotherClass another = new AnotherClass();
        another.addCookie(cookie); // Declaring type is not HttpServletResponse
    }
    
    // Minimal helper class to satisfy scenario
    static class AnotherClass {
        public void addCookie(Cookie cookie) {
            // Custom implementation, not javax.servlet.http.HttpServletResponse
        }
    }
}