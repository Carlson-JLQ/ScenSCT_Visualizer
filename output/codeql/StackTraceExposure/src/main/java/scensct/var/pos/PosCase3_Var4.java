// Scenario 3: printStackTrace directly to servlet writer sink, separate PrintWriter-on-StringWriter for different exception not flowing to response should be flagged as positive.
package scensct.var.pos;

import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PosCase3_Var4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        // Using a different exception class but same behavior
        Exception mainEx = new IllegalArgumentException("Bad input");
        PrintWriter writer = resp.getWriter();
        // Direct call via variable
        mainEx.printStackTrace(writer); // Should be flagged // [REPORTED LINE]
        
        // Separate block inlined differently
        String trace = new StringWriter() {
            { new RuntimeException("Hidden").printStackTrace(new PrintWriter(this)); }
        }.toString();
    }
}