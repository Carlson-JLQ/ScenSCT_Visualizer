// Tainted data sanitized before path sink should not be flagged as path injection.
package scensct.var.neg;

import java.io.File;
import javax.servlet.http.HttpServletRequest;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NegCase4_Var4 {
    public void safeFileOperation(HttpServletRequest request) {
        // Use try-catch for robustness, but preserve the sanitization flow
        try {
            String userPath = request.getParameter("path");
            Path p = Paths.get(userPath);
            String safePath = p.normalize().toAbsolutePath().normalize().toString();
            File file = new File(safePath);
            System.out.println(file.getAbsolutePath());
        } catch (Exception e) {
            // Handle exception without using tainted data
            System.err.println("Error processing path");
        }
    }
}