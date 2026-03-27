// Scenario 3: printStackTrace directly to servlet writer sink, separate PrintWriter-on-StringWriter for different exception not flowing to response should be flagged as positive.
package scensct.var.pos;

import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PosCase3_Var3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        // Using a loop to execute the flagged call once
        for (int i = 0; i < 1; i++) {
            Throwable t = new RuntimeException("Iterative error");
            t.printStackTrace(resp.getWriter()); // Should be flagged // [REPORTED LINE]
        }
        
        // Separate block with try-with-resources
        try (StringWriter sw = new StringWriter();
             PrintWriter pw = new PrintWriter(sw)) {
            new Error("Internal").printStackTrace(pw);
        } catch (Exception e) {
            // ignore
        }
    }
}