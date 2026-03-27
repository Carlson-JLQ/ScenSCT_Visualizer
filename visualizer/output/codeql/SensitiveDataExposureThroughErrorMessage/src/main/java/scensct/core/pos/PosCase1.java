// A method catches an exception, calls getMessage() on it, and passes the resulting string directly into an HTTP response output stream should be flagged as sensitive data exposure.
package scensct.core.pos;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PosCase1 {
    public void handleRequest(HttpServletResponse response) {
        try {
            // Simulate an operation that may throw an exception
            throw new RuntimeException("Database connection failed with credentials: admin/1234");
        } catch (RuntimeException e) {
            try {
                PrintWriter writer = response.getWriter();
                // Direct flow of sensitive exception message into HTTP response
                writer.print(e.getMessage()); // [REPORTED LINE]
            } catch (IOException ioException) {
                throw new RuntimeException(ioException);
            }
        }
    }
}