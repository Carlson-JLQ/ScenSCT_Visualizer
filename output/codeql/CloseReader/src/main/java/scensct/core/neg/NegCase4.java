// A ServletResponse.getOutputStream() argument should not be flagged as a resource leak.
package scensct.core.neg;

import javax.servlet.ServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

public class NegCase4 {
    public void test(ServletResponse response) throws IOException, ServletException {
        // Scenario 4: Underlying stream managed by servlet container.
        new java.io.PrintWriter(response.getWriter()); // No leak for the writer.
    }
}