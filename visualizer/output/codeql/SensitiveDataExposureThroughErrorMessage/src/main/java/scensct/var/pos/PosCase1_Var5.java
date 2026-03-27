// A method catches an exception, calls getMessage() on it, and passes the resulting string directly into an HTTP response output stream should be flagged as sensitive data exposure.
package scensct.var.pos;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PosCase1_Var5 {
    public void handleRequest(HttpServletResponse response) {
        RuntimeException exception = null;
        try {
            exception = new RuntimeException("Database connection failed with credentials: admin/1234");
            throw exception;
        } catch (RuntimeException e) {
            exception = e;
        }
        if (exception != null) {
            try {
                response.getWriter().print(exception.getMessage()); // [REPORTED LINE]
            } catch (IOException ioException) {
                throw new RuntimeException(ioException);
            }
        }
    }
}