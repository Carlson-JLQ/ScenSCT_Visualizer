// A Java source file containing no method calls to addCookie on javax.servlet.http.HttpServletResponse or jakarta.servlet.http.HttpServletResponse should not be flagged as insecure cookie.
package scensct.core.neg;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NegCase1 {
    public void handleResponse(HttpServletResponse response) throws IOException {
        // No addCookie call present, only other response operations
        response.setContentType("text/html");
        response.getWriter().println("Hello World");
    }
}