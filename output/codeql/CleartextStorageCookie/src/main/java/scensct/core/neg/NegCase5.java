// Sensitive data flows into the second argument of a javax.servlet.http.Cookie constructor and a method named "addCookie" is called but not from HttpServletResponse should not be flagged as storing sensitive data in a cleartext cookie.
package scensct.core.neg;

import javax.servlet.http.Cookie;

public class NegCase5 {
    public void method(String sensitiveData) {
        // Scenario 5: Custom class with addCookie method, not javax.servlet.http.HttpServletResponse
        Cookie cookie = new Cookie("name", sensitiveData);
        CustomResponse customResponse = new CustomResponse();
        customResponse.addCookie(cookie); // Custom addCookie, not from HttpServletResponse
    }
    
    // Helper custom class
    static class CustomResponse {
        public void addCookie(Cookie cookie) {
            // Custom implementation
        }
    }
}