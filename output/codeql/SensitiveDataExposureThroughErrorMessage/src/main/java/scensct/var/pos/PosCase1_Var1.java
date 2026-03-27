// A method catches an exception, calls getMessage() on it, and passes the resulting string directly into an HTTP response output stream should be flagged as sensitive data exposure.
package scensct.var.pos;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PosCase1_Var1 {
    public void handleRequest(HttpServletResponse response) {
        RuntimeException ex = new RuntimeException("Database connection failed with credentials: admin/1234");
        try {
            throw ex;
        } catch (RuntimeException e) {
            PrintWriter out = null;
            try {
                out = response.getWriter();
                String msg = e.getMessage();
                out.print(msg); // [REPORTED LINE]
            } catch (IOException ioException) {
                throw new RuntimeException(ioException);
            } finally {
                if (out != null) {
                    out.close();
                }
            }
        }
    }
}