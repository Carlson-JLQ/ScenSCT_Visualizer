// Scenario 1: printStackTrace with argument flowing to servlet writer sink, no PrintWriter-on-StringWriter present should be flagged as positive.
package scensct.var.pos;

import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PosCase1_Var5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        PrintWriter writer = null;
        try {
            writer = resp.getWriter();
            throw new RuntimeException("Error in processing");
        } catch (RuntimeException e) {
            if (writer != null) {
                e.printStackTrace(writer); // [REPORTED LINE]
            }
        }
    }
}