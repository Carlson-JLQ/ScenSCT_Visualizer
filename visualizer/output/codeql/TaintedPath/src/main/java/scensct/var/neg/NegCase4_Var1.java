// Tainted data sanitized before path sink should not be flagged as path injection.
package scensct.var.neg;

import java.io.File;
import javax.servlet.http.HttpServletRequest;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NegCase4_Var1 {
    public void safeFileOperation(HttpServletRequest request) {
        String input = request.getParameter("path");
        // Split normalization into separate steps
        Path tempPath = Paths.get(input);
        Path normalized = tempPath.normalize();
        String clean = normalized.toString();
        // Sink with sanitized data
        File f = new File(clean);
        System.out.println(f.getAbsolutePath());
    }
}