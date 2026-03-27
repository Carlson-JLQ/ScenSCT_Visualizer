// Scenario 4: printStackTrace directly to servlet writer sink, PrintWriter-on-StringWriter present but not used for exception E should be flagged as positive.
package scensct.var.pos;

import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PosCase4_Var1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        // Variant 1: Lexical refactoring with different exception and variable names
        IllegalStateException error = new IllegalStateException("Something went wrong");
        
        // Unused PrintWriter-on-StringWriter with different variable names
        StringWriter buffer = new StringWriter();
        PrintWriter printer = new PrintWriter(buffer);
        
        // Direct sink call with temporary variable
        PrintWriter responseWriter = resp.getWriter();
        error.printStackTrace(responseWriter); // [REPORTED LINE]
    }
}