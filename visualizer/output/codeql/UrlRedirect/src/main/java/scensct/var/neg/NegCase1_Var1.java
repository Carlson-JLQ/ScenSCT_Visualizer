// Constant string passed to sendRedirect should not be flagged as untrusted URL redirection.
package scensct.var.neg;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NegCase1_Var1 {
    private static final String HOME_PAGE = "/trusted/home.jsp";
    
    public void doGet(HttpServletResponse response) throws IOException {
        response.sendRedirect(HOME_PAGE);
    }
}