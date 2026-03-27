// Scenario 5: printStackTrace with SuperAccess qualifier to servlet writer sink, separate PrintWriter-on-StringWriter for same exception not flowing to response should be flagged as positive.
package scensct.var.pos;

import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PosCase5_Var2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        // Change exception type to a custom one (still RuntimeException)
        RuntimeException e = new CustomRuntimeException("Shared error");
        
        // Separate path: move StringWriter logic into a helper method that returns nothing
        logStackTraceLocally(e);
        
        // Super-access via a different chain: using a method that returns the writer
        PrintWriter writer = obtainServletWriter();
        e.printStackTrace(writer); // [REPORTED LINE]
    }
    
    private void logStackTraceLocally(RuntimeException ex) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        String trace = sw.toString(); // Not used externally
    }
    
    private PrintWriter obtainServletWriter() {
        // Still a super-access qualifier but via a method call
        return super.getServletContext().getResponse().getWriter();
    }
    
    static class CustomRuntimeException extends RuntimeException {
        CustomRuntimeException(String msg) { super(msg); }
    }
}