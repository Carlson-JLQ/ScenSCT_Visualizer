// Tainted source and path sink present but isolated should not be flagged as path injection.
package scensct.core.neg;

import java.io.File;
import javax.servlet.http.HttpServletRequest;

public class NegCase3 {
    public void handleRequest(HttpServletRequest request) {
        // Tainted source: user input
        String tainted = request.getParameter("file");
        // Isolated sink: uses different variable (literal), no flow from tainted
        File safeFile = new File("default.txt");
        System.out.println(safeFile.getName());
        // Tainted variable used elsewhere but not in sink
        System.out.println("Log: " + tainted);
    }
}