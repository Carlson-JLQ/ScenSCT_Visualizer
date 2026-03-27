// A method catches an exception, calls getMessage() on it, and passes the resulting string directly into an HTTP response output stream should be flagged as sensitive data exposure.
package scensct.var.pos;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PosCase1_Var2 {
    public void handleRequest(HttpServletResponse response) {
        try {
            riskyOperation();
        } catch (Exception e) {
            writeToResponse(response, e);
        }
    }

    private void riskyOperation() {
        throw new RuntimeException("Database connection failed with credentials: admin/1234");
    }

    private void writeToResponse(HttpServletResponse response, Throwable t) {
        try {
            PrintWriter writer = response.getWriter();
            writer.print(t.getMessage()); // [REPORTED LINE]
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
    }
}