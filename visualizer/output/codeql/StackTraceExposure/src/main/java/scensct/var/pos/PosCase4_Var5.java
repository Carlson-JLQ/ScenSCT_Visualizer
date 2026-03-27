// Scenario 4: printStackTrace directly to servlet writer sink, PrintWriter-on-StringWriter present but not used for exception E should be flagged as positive.
package scensct.var.pos;

import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PosCase4_Var5 extends HttpServlet {
    // Variant 5: Split initialization and sink call with intermediate steps
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        // Exception with cause chain
        RuntimeException rootCause = new RuntimeException("Root cause");
        RuntimeException e = new RuntimeException("Wrapper", rootCause);
        
        // PrintWriter-on-StringWriter initialized in separate steps
        StringWriter sw;
        PrintWriter pw;
        sw = new StringWriter();
        pw = new PrintWriter(sw);
        
        // Use pw for something else (not e's stack trace)
        pw.println("Debug info");
        
        // Direct sink call via method chain
        e.printStackTrace(resp.getWriter()); // [REPORTED LINE]
    }
}