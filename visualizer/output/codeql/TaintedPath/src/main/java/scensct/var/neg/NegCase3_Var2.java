// Tainted source and path sink present but isolated should not be flagged as path injection.
package scensct.var.neg;

import java.io.File;
import javax.servlet.http.HttpServletRequest;

public class NegCase3_Var2 {
    public void handleRequest(HttpServletRequest request) {
        String tainted = request.getParameter("file");
        // Introduce a temporary variable that aliases the literal
        String base = "default";
        String extension = ".txt";
        String path = base + extension;
        File safeFile = createFile(path);
        System.out.println(safeFile.getName());
        // Use tainted in a conditional branch that doesn't affect the sink
        if (tainted != null) {
            System.out.println("Received: " + tainted);
        }
    }
    
    private File createFile(String p) {
        return new File(p);
    }
}