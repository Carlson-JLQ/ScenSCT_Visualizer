// A method catches an exception, calls getMessage() on it, and passes the resulting string directly into an HTTP response output stream should be flagged as sensitive data exposure.
package scensct.var.pos;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PosCase1_Var3 {
    public void handleRequest(HttpServletResponse response) {
        RuntimeException e = new RuntimeException("Database connection failed with credentials: admin/1234");
        if (response != null) {
            try {
                PrintWriter w = response.getWriter();
                w.print(e.getMessage()); // [REPORTED LINE]
            } catch (IOException ioe) {
                throw new RuntimeException(ioe);
            }
        }
    }
}