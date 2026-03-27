// A ServletResponse.getOutputStream() argument should not be flagged as a resource leak.
package scensct.var.neg;

import javax.servlet.ServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

public class NegCase4_Var5 {
    // Variant 5: Control-flow restructuring with conditional that doesn't affect resource ownership.
    public void test(ServletResponse response) throws IOException, ServletException {
        boolean useWriter = true;
        PrintWriter pw = null;
        if (useWriter) {
            pw = new PrintWriter(response.getWriter());
        } else {
            // Dead branch, but checker must still see the servlet-managed resource.
            pw = new PrintWriter(response.getWriter());
        }
        // pw is not closed; underlying writer is container-managed.
    }
}