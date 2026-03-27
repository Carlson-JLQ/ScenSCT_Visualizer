// Scenario 5: printStackTrace with SuperAccess qualifier to servlet writer sink, separate PrintWriter-on-StringWriter for same exception not flowing to response should be flagged as positive.
package scensct.core.pos;

import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PosCase5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        RuntimeException e = new RuntimeException("Shared error");
        
        // Separate PrintWriter-on-StringWriter configuration for same exception
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw); // Same exception printed to StringWriter
        String trace = sw.toString(); // Converted to string but not used in response
        
        // Direct printStackTrace with SuperAccess qualifier to servlet writer sink
        // Using super.getWriter() as an example of SuperAccess qualifier
        e.printStackTrace(super.getServletContext().getResponse().getWriter()); // Should be flagged // [REPORTED LINE]
    }
    
    // Helper method to simulate SuperAccess scenario
    private javax.servlet.ServletResponse getServletResponse() {
        // This method would typically be overridden or accessed via super
        return null;
    }
}