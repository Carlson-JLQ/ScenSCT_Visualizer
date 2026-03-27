// A method catches an exception, calls getMessage() on it, and passes the resulting string directly into an HTTP response output stream should be flagged as sensitive data exposure.
package scensct.var.pos;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PosCase1_Var4 {
    public void handleRequest(HttpServletResponse response) {
        try {
            throw new RuntimeException("Database connection failed with credentials: admin/1234");
        } catch (RuntimeException e) {
            try (PrintWriter writer = response.getWriter()) {
                writer.println(e.getMessage()); // [REPORTED LINE]
            } catch (IOException ioException) {
                throw new RuntimeException(ioException);
            }
        }
    }
}