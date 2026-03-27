// Scenario 1: printStackTrace with argument flowing to servlet writer sink, no PrintWriter-on-StringWriter present should be flagged as positive.
package scensct.var.pos;

import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PosCase1_Var3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        boolean shouldProcess = true;
        if (shouldProcess) {
            try {
                performOperation();
            } catch (RuntimeException e) {
                PrintWriter pw = resp.getWriter();
                e.printStackTrace(pw); // [REPORTED LINE]
            }
        }
    }

    private void performOperation() {
        throw new RuntimeException("Operation failed");
    }
}