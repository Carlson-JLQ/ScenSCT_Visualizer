// Scenario 4: printStackTrace directly to servlet writer sink, PrintWriter-on-StringWriter present but not used for exception E should be flagged as positive.
package scensct.var.pos;

import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PosCase4_Var2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        // Variant 2: Control flow restructuring with always-true condition
        RuntimeException e = new RuntimeException("Main error");
        
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        
        if (req != null) { // Always true in servlet context
            // The sink is inside a branch, but always reachable
            e.printStackTrace(resp.getWriter()); // [REPORTED LINE]
        }
        // pw remains unused for e
    }
}