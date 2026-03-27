// Tainted data sanitized before path sink should not be flagged as path injection.
package scensct.core.neg;

import java.io.File;
import javax.servlet.http.HttpServletRequest;
import java.nio.file.Paths;

public class NegCase4 {
    public void safeFileOperation(HttpServletRequest request) {
        // Tainted source: user input
        String userPath = request.getParameter("path");
        // Sanitization: normalize path to remove dangerous sequences
        String safePath = Paths.get(userPath).normalize().toString();
        // Sink: path operation with sanitized data
        File file = new File(safePath);
        System.out.println(file.getAbsolutePath());
    }
}