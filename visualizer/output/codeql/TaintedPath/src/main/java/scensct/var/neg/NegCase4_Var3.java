// Tainted data sanitized before path sink should not be flagged as path injection.
package scensct.var.neg;

import java.io.File;
import javax.servlet.http.HttpServletRequest;
import java.nio.file.Paths;

public class NegCase4_Var3 {
    public void safeFileOperation(HttpServletRequest request) {
        String userPath = request.getParameter("path");
        // Introduce a conditional that does not affect the path flow
        if (userPath != null && !userPath.isEmpty()) {
            String safePath = Paths.get(userPath).normalize().toString();
            File file = new File(safePath);
            System.out.println(file.getAbsolutePath());
        } else {
            // Fallback with a safe default, still no taint flow to sink
            File file = new File("default.txt");
            System.out.println(file.getAbsolutePath());
        }
    }
}