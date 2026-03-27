// Scenario 3: printStackTrace directly to servlet writer sink, separate PrintWriter-on-StringWriter for different exception not flowing to response should be flagged as positive.
package scensct.var.pos;

import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PosCase3_Var5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        // Wrapped in a try-catch-finally where finally does the flagged call
        try {
            // some operation
            int x = 1 / 1; // no error
        } catch (ArithmeticException e) {
            // not used
        } finally {
            new RuntimeException("Finally error").printStackTrace(resp.getWriter()); // Should be flagged // [REPORTED LINE]
        }
        
        // Separate block extracted to a method that returns unused string
        String unused = captureTrace(new IllegalStateException("Detached"));
    }
    
    private String captureTrace(RuntimeException e) {
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));
        return sw.toString();
    }
}