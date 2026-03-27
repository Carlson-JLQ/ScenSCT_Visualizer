// Scenario 3: printStackTrace directly to servlet writer sink, separate PrintWriter-on-StringWriter for different exception not flowing to response should be flagged as positive.
package scensct.var.pos;

import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PosCase3_Var1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        // Renamed parameters and variables, swapped order of declarations
        RuntimeException ex = new RuntimeException("Primary error");
        // Moved the sink call into a conditional that always executes
        if (response != null) {
            ex.printStackTrace(response.getWriter()); // Should be flagged // [REPORTED LINE]
        }
        
        // Separate block with different structure
        Exception another = new IllegalStateException("Secondary");
        StringWriter buffer = new StringWriter();
        another.printStackTrace(new PrintWriter(buffer));
        String result = buffer.toString();
        // result not used in response
    }
}