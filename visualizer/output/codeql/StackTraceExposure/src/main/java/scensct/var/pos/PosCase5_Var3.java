// Scenario 5: printStackTrace with SuperAccess qualifier to servlet writer sink, separate PrintWriter-on-StringWriter for same exception not flowing to response should be flagged as positive.
package scensct.var.pos;

import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PosCase5_Var3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        // Introduce a conditional that always takes the true branch
        boolean flag = true;
        RuntimeException e = null;
        if (flag) {
            e = new RuntimeException("Shared error");
        } else {
            e = new RuntimeException("Never happens");
        }
        
        // Separate path: wrap in a try-catch-finally that does nothing with the trace
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            // trace not used
        } finally {
            // empty
        }
        
        // Super-access qualifier: split across multiple lines with intermediate variables
        javax.servlet.ServletContext ctx = super.getServletContext();
        javax.servlet.ServletResponse servletResp = ctx.getResponse();
        PrintWriter sink = servletResp.getWriter();
        e.printStackTrace(sink); // [REPORTED LINE]
    }
}