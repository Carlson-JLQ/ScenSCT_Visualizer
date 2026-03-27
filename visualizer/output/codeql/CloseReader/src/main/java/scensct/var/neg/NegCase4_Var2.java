// A ServletResponse.getOutputStream() argument should not be flagged as a resource leak.
package scensct.var.neg;

import javax.servlet.ServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

public class NegCase4_Var2 {
    // Variant 2: Intra-procedural refactoring - use try-with-resources on an unrelated resource.
    public void test(ServletResponse response) throws IOException, ServletException {
        // Unrelated auto-closeable to stress control-flow analysis.
        try (var dummy = new java.io.ByteArrayInputStream(new byte[0])) {
            PrintWriter pw = new PrintWriter(response.getWriter());
        }
        // The PrintWriter is not closed, but the servlet container manages the underlying writer.
    }
}