// Constant string passed to sendRedirect should not be flagged as untrusted URL redirection.
package scensct.var.neg;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NegCase1_Var3 {
    public void doGet(HttpServletResponse response) throws IOException {
        String base = "/trusted/";
        String page = "home.jsp";
        response.sendRedirect(base + page);
    }
}