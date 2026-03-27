// Taint broken by transformation before path sink should not be flagged as path injection.
package scensct.var.neg;

import java.io.File;
import javax.servlet.http.HttpServletRequest;

public class NegCase5_Var2 {
    // Variant 2: Extract transformation to a helper method that returns safe string
    public void transformTaint(HttpServletRequest request) {
        String raw = request.getParameter("input");
        String finalPath = sanitize(raw);
        File file = new File(finalPath);
        System.out.println(file.getName());
    }

    private String sanitize(String tainted) {
        String withPrefix = "prefix_" + tainted;
        String withSuffix = withPrefix + "_suffix";
        // After concatenations, remove the fixed parts
        return withSuffix.substring(7, withSuffix.length() - 7);
    }
}