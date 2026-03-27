// A Java source file containing no method calls to addCookie on javax.servlet.http.HttpServletResponse or jakarta.servlet.http.HttpServletResponse should not be flagged as insecure cookie.
package scensct.var.neg;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NegCase1_Var1 {
    public void handleResponse(HttpServletResponse response) throws IOException {
        // Introduce an alias and a temporary variable, but still no addCookie
        HttpServletResponse resp = response;
        resp.setContentType("text/html");
        var writer = resp.getWriter();
        writer.println("Hello World");
        // Additional unrelated header setting
        resp.setHeader("Cache-Control", "no-cache");
    }
}