// Scenario 3: printStackTrace directly to servlet writer sink, separate PrintWriter-on-StringWriter for different exception not flowing to response should be flagged as positive.
package scensct.core.pos;

import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PosCase3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        // First exception: direct printStackTrace to servlet writer sink
        RuntimeException e1 = new RuntimeException("Error 1");
        e1.printStackTrace(resp.getWriter()); // Should be flagged // [REPORTED LINE]
        
        // Separate PrintWriter-on-StringWriter configuration for different exception
        RuntimeException e2 = new RuntimeException("Error 2");
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e2.printStackTrace(pw); // Different exception printed to StringWriter
        String trace = sw.toString(); // Converted to string but not used in response
        // trace does not flow to HTTP response
    }
}