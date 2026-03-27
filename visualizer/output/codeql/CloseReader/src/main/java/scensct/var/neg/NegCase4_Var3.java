// A ServletResponse.getOutputStream() argument should not be flagged as a resource leak.
package scensct.var.neg;

import javax.servlet.ServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

public class NegCase4_Var3 {
    // Variant 3: Inter-procedural refactoring - extract creation to a helper method.
    public void test(ServletResponse response) throws IOException, ServletException {
        createPrintWriter(response);
    }

    private void createPrintWriter(ServletResponse sr) throws IOException {
        new PrintWriter(sr.getWriter());
    }
}