// Tainted data sanitized before path sink should not be flagged as path injection.
package scensct.var.neg;

import java.io.File;
import javax.servlet.http.HttpServletRequest;
import java.nio.file.Paths;

public class NegCase4_Var2 {
    private String sanitizePath(String raw) {
        // Extract sanitization to a helper method
        return Paths.get(raw).normalize().toString();
    }

    public void safeFileOperation(HttpServletRequest request) {
        String userPath = request.getParameter("path");
        String safePath = sanitizePath(userPath);
        // Sink remains the same
        File file = new File(safePath);
        System.out.println(file.getAbsolutePath());
    }
}