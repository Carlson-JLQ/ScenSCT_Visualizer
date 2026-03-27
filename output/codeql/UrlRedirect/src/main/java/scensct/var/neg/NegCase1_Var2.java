// Constant string passed to sendRedirect should not be flagged as untrusted URL redirection.
package scensct.var.neg;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NegCase1_Var2 {
    public void doGet(HttpServletResponse response) throws IOException {
        String target = getHomePage();
        response.sendRedirect(target);
    }
    
    private String getHomePage() {
        return "/trusted/home.jsp";
    }
}