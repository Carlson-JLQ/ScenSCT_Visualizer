// Scenario 1: printStackTrace with argument flowing to servlet writer sink, no PrintWriter-on-StringWriter present should be flagged as positive.
package scensct.core.pos;

import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PosCase1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            // Simulate an operation that may throw an exception
            throw new RuntimeException("Error in processing");
        } catch (RuntimeException e) {
            // Direct printStackTrace call with argument that flows to servlet writer sink
            e.printStackTrace(resp.getWriter()); // Should be flagged // [REPORTED LINE]
        }
    }
}