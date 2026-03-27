// Scenario 1: printStackTrace with argument flowing to servlet writer sink, no PrintWriter-on-StringWriter present should be flagged as positive.
package scensct.var.pos;

import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PosCase1_Var2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        RuntimeException error = new RuntimeException("Error in processing");
        handleException(error, resp);
    }

    private void handleException(RuntimeException e, HttpServletResponse resp) {
        try {
            throw e;
        } catch (RuntimeException caught) {
            caught.printStackTrace(resp.getWriter()); // [REPORTED LINE]
        }
    }
}