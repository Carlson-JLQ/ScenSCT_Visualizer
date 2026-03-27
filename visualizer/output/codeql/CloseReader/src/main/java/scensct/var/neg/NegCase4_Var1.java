// A ServletResponse.getOutputStream() argument should not be flagged as a resource leak.
package scensct.var.neg;

import javax.servlet.ServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

public class NegCase4_Var1 {
    // Variant 1: Lexical refactoring - rename method parameter, use temporary variable.
    public void test(ServletResponse resp) throws IOException, ServletException {
        var writer = resp.getWriter();
        new java.io.PrintWriter(writer);
    }
}