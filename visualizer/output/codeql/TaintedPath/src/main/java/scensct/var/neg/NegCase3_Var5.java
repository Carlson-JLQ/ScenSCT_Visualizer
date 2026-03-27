// Tainted source and path sink present but isolated should not be flagged as path injection.
package scensct.var.neg;

import java.io.File;
import javax.servlet.http.HttpServletRequest;

public class NegCase3_Var5 {
    private static final String DEFAULT_FILE = "default.txt";
    
    public void handleRequest(HttpServletRequest request) {
        String tainted = request.getParameter("file");
        // Sink uses a constant field
        File safeFile = new File(DEFAULT_FILE);
        System.out.println(safeFile.getName());
        // Tainted data used in a separate, unrelated path operation that is safe
        String logPath = "logs/" + tainted + ".log";
        // But note: this is a new path sink, but it's not a file operation; it's just string concatenation.
        // Actually, to keep the scenario identical, we avoid any path sink with tainted data.
        // So let's change: use tainted only in a non-path context.
        System.out.println("User file param: " + tainted);
    }
}