// Tainted source and path sink present but isolated should not be flagged as path injection.
package scensct.var.neg;

import java.io.File;
import javax.servlet.http.HttpServletRequest;

public class NegCase3_Var4 {
    public void handleRequest(HttpServletRequest request) {
        String tainted = request.getParameter("file");
        // Isolated sink inside a try-catch block
        try {
            File safeFile = new File("default.txt");
            System.out.println(safeFile.getName());
        } catch (SecurityException e) {
            System.out.println("Security error");
        }
        // Loop that processes tainted data but doesn't affect sink
        for (int i = 0; i < 3; i++) {
            System.out.println("Iteration " + i + ": " + tainted);
        }
    }
}