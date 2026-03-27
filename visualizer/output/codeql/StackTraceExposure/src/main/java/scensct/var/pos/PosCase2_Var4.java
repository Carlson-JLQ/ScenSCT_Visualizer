// Scenario 2: Exception stack trace written to StringWriter via PrintWriter, then string flows to HTTP response should be flagged as positive.
package scensct.var.pos;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PosCase2_Var4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            throw new RuntimeException("Internal error");
        } catch (RuntimeException e) {
            // Use PrintStream with ByteArrayOutputStream instead of StringWriter/PrintWriter
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(baos);
            e.printStackTrace(ps);
            ps.flush();
            String stackTraceStr = baos.toString();
            resp.getWriter().write(stackTraceStr);
        }
    }
}