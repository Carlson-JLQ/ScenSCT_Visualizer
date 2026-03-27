// Scenario 2: Exception stack trace written to StringWriter via PrintWriter, then string flows to HTTP response should be flagged as positive.
package scensct.var.pos;

import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PosCase2_Var1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            throw new RuntimeException("Something went wrong");
        } catch (RuntimeException ex) {
            // Use try-with-resources for PrintWriter
            StringWriter buffer = new StringWriter();
            try (PrintWriter printer = new PrintWriter(buffer)) {
                ex.printStackTrace(printer);
            }
            String trace = buffer.toString();
            resp.getWriter().write(trace); // [REPORTED LINE]
        }
    }
}