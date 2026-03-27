// Scenario 1: printStackTrace with argument flowing to servlet writer sink, no PrintWriter-on-StringWriter present should be flagged as positive.
package scensct.var.pos;

import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PosCase1_Var1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            throw new IllegalStateException("Processing failure");
        } catch (Exception ex) {
            PrintWriter writer = resp.getWriter();
            ex.printStackTrace(writer); // [REPORTED LINE]
        }
    }
}