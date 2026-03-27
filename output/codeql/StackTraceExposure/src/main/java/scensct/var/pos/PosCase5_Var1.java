// Scenario 5: printStackTrace with SuperAccess qualifier to servlet writer sink, separate PrintWriter-on-StringWriter for same exception not flowing to response should be flagged as positive.
package scensct.var.pos;

import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PosCase5_Var1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        // Introduce a temporary variable for the exception
        Throwable ex = new RuntimeException("Shared error");
        
        // Reorder: do the safe StringWriter usage after the risky one? No, keep reachability.
        // Instead, extract the sink acquisition into a local variable with a different super-access chain
        PrintWriter servletWriter = super.getServletContext().getResponse().getWriter();
        
        // Separate path: use a try-with-resources for the StringWriter (idiomatic)
        try (StringWriter sw = new StringWriter(); PrintWriter pw = new PrintWriter(sw)) {
            ex.printStackTrace(pw);
            String trace = sw.toString(); // Not used
        } catch (Exception e2) {
            // ignore
        }
        
        // Direct printStackTrace with the acquired servlet writer
        ex.printStackTrace(servletWriter); // [REPORTED LINE]
    }
}