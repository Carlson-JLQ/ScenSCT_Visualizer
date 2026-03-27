// A Cookie object instantiated via a method other than the javax.servlet.http.Cookie or jakarta.servlet.http.Cookie constructor should not be flagged as storing sensitive data in a cleartext cookie.
package scensct.core.neg;

import javax.servlet.http.HttpServletResponse;

public class NegCase1 {
    public void method(HttpServletResponse response, String sensitiveData) {
        // Scenario 1: Using a different class named Cookie (not javax.servlet.http.Cookie)
        com.exp.Cookie customCookie = new com.exp.Cookie("name", sensitiveData);
        // The addCookie call is on HttpServletResponse, but the cookie is not a javax.servlet.http.Cookie
        response.addCookie(customCookie); // This should not trigger the checker
    }
}