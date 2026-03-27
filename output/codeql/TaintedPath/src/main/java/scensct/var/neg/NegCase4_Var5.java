// Tainted data sanitized before path sink should not be flagged as path injection.
package scensct.var.neg;

import java.io.File;
import javax.servlet.http.HttpServletRequest;
import java.nio.file.Paths;

public class NegCase4_Var5 {
    public void safeFileOperation(HttpServletRequest request) {
        // Chain with temporary variable and alias
        String tainted = request.getParameter("path");
        String intermediate = tainted;
        String safe = Paths.get(intermediate).normalize().toString();
        // Use parent/child constructor but still safe
        File parent = new File("/base");
        File file = new File(parent, safe);
        System.out.println(file.getAbsolutePath());
    }
}