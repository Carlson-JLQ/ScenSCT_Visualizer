// Scenario 2: Exception stack trace written to StringWriter via PrintWriter, then string flows to HTTP response should be flagged as positive.
package scensct.core.pos;

import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PosCase2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            throw new RuntimeException("Internal error");
        } catch (RuntimeException e) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw); // Print stack trace to StringWriter via PrintWriter
            String stackTraceStr = sw.toString(); // Convert to string
            resp.getWriter().write(stackTraceStr); // Write string to HTTP response - should be flagged // [REPORTED LINE]
        }
    }
}