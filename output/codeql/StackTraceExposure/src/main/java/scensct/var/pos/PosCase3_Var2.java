// Scenario 3: printStackTrace directly to servlet writer sink, separate PrintWriter-on-StringWriter for different exception not flowing to response should be flagged as positive.
package scensct.var.pos;

import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PosCase3_Var2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        // Extracted the flagged logic into a helper method
        logErrorToResponse(new RuntimeException("Fault"), resp);
        
        // Unchanged irrelevant block
        RuntimeException e2 = new RuntimeException("Error 2");
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e2.printStackTrace(pw);
        String trace = sw.toString();
    }
    
    private void logErrorToResponse(RuntimeException e, HttpServletResponse resp) {
        // Helper passes the servlet writer directly
        e.printStackTrace(resp.getWriter()); // Should be flagged // [REPORTED LINE]
    }
}