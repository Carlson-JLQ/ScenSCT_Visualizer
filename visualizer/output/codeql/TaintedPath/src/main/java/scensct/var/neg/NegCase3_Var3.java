// Tainted source and path sink present but isolated should not be flagged as path injection.
package scensct.var.neg;

import java.io.File;
import javax.servlet.http.HttpServletRequest;

public class NegCase3_Var3 {
    public void handleRequest(HttpServletRequest request) {
        // Tainted source via wrapper method
        String tainted = getTaintedInput(request);
        // Sink with literal constructed via StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("default");
        sb.append(".txt");
        File safeFile = new File(sb.toString());
        System.out.println(safeFile.getName());
        // Tainted variable passed to a side-effect-only method
        audit(tainted);
    }
    
    private String getTaintedInput(HttpServletRequest req) {
        return req.getParameter("file");
    }
    
    private void audit(String msg) {
        System.out.println("Audit: " + msg);
    }
}