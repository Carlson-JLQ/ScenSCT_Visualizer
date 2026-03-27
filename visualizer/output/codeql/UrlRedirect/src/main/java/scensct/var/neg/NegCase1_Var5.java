// Constant string passed to sendRedirect should not be flagged as untrusted URL redirection.
package scensct.var.neg;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NegCase1_Var5 {
    public void doGet(HttpServletResponse response) throws IOException {
        int code = 1;
        String url = switch (code) {
            case 1 -> "/trusted/home.jsp";
            default -> "/trusted/default.jsp";
        };
        response.sendRedirect(url);
    }
}