// A Java source file containing no method calls to addCookie on javax.servlet.http.HttpServletResponse or jakarta.servlet.http.HttpServletResponse should not be flagged as insecure cookie.
package scensct.var.neg;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NegCase1_Var3 {
    // Extract a helper method that performs non-cookie operations
    private void writeContent(HttpServletResponse response) throws IOException {
        response.getWriter().println("Hello World");
    }

    public void handleResponse(HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        writeContent(response);
        // Mimic cookie-like operation on a different object (e.g., a mock)
        String dummyCookie = "session=abc; Path=/";
        // But never call response.addCookie(...)
    }
}