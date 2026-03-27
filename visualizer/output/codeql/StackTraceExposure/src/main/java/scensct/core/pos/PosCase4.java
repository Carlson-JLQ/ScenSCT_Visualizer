// Scenario 4: printStackTrace directly to servlet writer sink, PrintWriter-on-StringWriter present but not used for exception E should be flagged as positive.
package scensct.core.pos;

import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PosCase4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        RuntimeException e = new RuntimeException("Main error");
        
        // PrintWriter-on-StringWriter configuration present
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        // pw is not used to print stack trace of exception e
        
        // Direct printStackTrace to servlet writer sink
        e.printStackTrace(resp.getWriter()); // Should be flagged // [REPORTED LINE]
    }
}