// Scenario 5: printStackTrace with SuperAccess qualifier to servlet writer sink, separate PrintWriter-on-StringWriter for same exception not flowing to response should be flagged as positive.
package scensct.var.pos;

import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PosCase5_Var4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        // Create exception in a static helper
        RuntimeException e = createException();
        
        // Separate path: use a lambda to consume the exception (but not affect flow)
        Runnable r = () -> {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            // trace discarded
        };
        r.run();
        
        // Super-access via an indirect method that passes 'this'
        PrintWriter writer = getWriterViaSuper(this);
        e.printStackTrace(writer); // [REPORTED LINE]
    }
    
    private static RuntimeException createException() {
        return new RuntimeException("Shared error");
    }
    
    private PrintWriter getWriterViaSuper(HttpServlet servlet) {
        // The super qualifier is still present, but now via the parameter
        return servlet.getServletContext().getResponse().getWriter();
    }
}