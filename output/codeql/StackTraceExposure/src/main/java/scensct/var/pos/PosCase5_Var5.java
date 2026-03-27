// Scenario 5: printStackTrace with SuperAccess qualifier to servlet writer sink, separate PrintWriter-on-StringWriter for same exception not flowing to response should be flagged as positive.
package scensct.var.pos;

import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PosCase5_Var5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        // Use a generic Exception type
        Exception e = new RuntimeException("Shared error");
        
        // Separate path: print to StringWriter and then ignore it via a method that returns void
        captureToString(e);
        
        // Super-access qualifier: use a different super method chain (assuming getResponse() is available)
        // Note: The original chain was super.getServletContext().getResponse().getWriter()
        // We'll keep the same logical chain but with a temporary variable for the context.
        javax.servlet.ServletContext sc = super.getServletContext();
        javax.servlet.ServletResponse sr = sc.getResponse();
        PrintWriter pw = sr.getWriter();
        e.printStackTrace(pw); // [REPORTED LINE]
    }
    
    private void captureToString(Exception ex) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        // sw.toString() not used
    }
}