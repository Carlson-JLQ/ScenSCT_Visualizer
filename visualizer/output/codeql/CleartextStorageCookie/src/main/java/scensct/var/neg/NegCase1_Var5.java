// A Cookie object instantiated via a method other than the javax.servlet.http.Cookie or jakarta.servlet.http.Cookie constructor should not be flagged as storing sensitive data in a cleartext cookie.
package scensct.var.neg;

import javax.servlet.http.HttpServletResponse;

public class NegCase1_Var5 {
    public void method(HttpServletResponse response, String sensitiveData) {
        // Variant 5: Use a try-finally block where cookie is created in try and added in finally.
        com.exp.Cookie customCookie = null;
        try {
            customCookie = new com.exp.Cookie("id", sensitiveData.trim()); // trivial method call on data
        } finally {
            if (customCookie != null) {
                response.addCookie(customCookie);
            }
        }
    }
}