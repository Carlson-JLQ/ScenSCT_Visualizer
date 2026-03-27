// Scenario 4: printStackTrace directly to servlet writer sink, PrintWriter-on-StringWriter present but not used for exception E should be flagged as positive.
package scensct.var.pos;

import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PosCase4_Var3 extends HttpServlet {
    // Variant 3: Inter-procedural refactoring - extract unused PrintWriter setup
    private PrintWriter createUnusedPrintWriter() {
        StringWriter sw = new StringWriter();
        return new PrintWriter(sw);
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        RuntimeException e = new RuntimeException("Main error");
        
        // Call helper but ignore result for the exception
        PrintWriter unused = createUnusedPrintWriter();
        
        // Direct sink call
        e.printStackTrace(resp.getWriter()); // [REPORTED LINE]
    }
}