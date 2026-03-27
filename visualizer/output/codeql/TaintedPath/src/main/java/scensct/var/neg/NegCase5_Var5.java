// Taint broken by transformation before path sink should not be flagged as path injection.
package scensct.var.neg;

import java.io.File;
import javax.servlet.http.HttpServletRequest;

public class NegCase5_Var5 {
    // Variant 5: Use String.format and then replace to remove fixed parts
    public void transformTaint(HttpServletRequest request) {
        String raw = request.getParameter("input");
        String transformed = String.format("prefix_%s_suffix", raw);
        // Remove first 7 chars and last 7 chars by replacing them with empty string
        String finalPath = transformed
            .replaceFirst("^prefix_", "")
            .replaceFirst("_suffix$", "");
        File file = new File(finalPath);
        System.out.println(file.getName());
    }
}