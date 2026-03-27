// A Cookie object instantiated via a method other than the javax.servlet.http.Cookie or jakarta.servlet.http.Cookie constructor should not be flagged as storing sensitive data in a cleartext cookie.
package scensct.var.neg;

import javax.servlet.http.HttpServletResponse;

public class NegCase1_Var1 {
    public void method(HttpServletResponse response, String sensitiveData) {
        // Variant 1: Introduce a temporary variable and a conditional that always takes the true branch.
        String cookieValue = sensitiveData;
        if (response != null) {
            com.exp.Cookie c = new com.exp.Cookie("sessionId", cookieValue);
            response.addCookie(c);
        }
    }
}