// Scenario 1: printStackTrace with argument flowing to servlet writer sink, no PrintWriter-on-StringWriter present should be flagged as positive.
package scensct.var.pos;

import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PosCase1_Var4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            riskyTask();
        } finally {
            // Exception from try block is caught here
            Throwable t = new RuntimeException("Error occurred");
            t.printStackTrace(resp.getWriter()); // [REPORTED LINE]
        }
    }

    private void riskyTask() {
        // Simulate an error
        throw new RuntimeException("Error in processing");
    }
}