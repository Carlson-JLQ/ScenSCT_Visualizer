// Taint broken by transformation before path sink should not be flagged as path injection.
package scensct.var.neg;

import java.io.File;
import javax.servlet.http.HttpServletRequest;

public class NegCase5_Var1 {
    // Variant 1: Refactor with StringBuilder and explicit length calculation
    public void transformTaint(HttpServletRequest request) {
        String raw = request.getParameter("input");
        StringBuilder sb = new StringBuilder();
        sb.append("prefix_");
        sb.append(raw);
        sb.append("_suffix");
        String transformed = sb.toString();
        // substring removes "prefix_" (7 chars) and "_suffix" (7 chars)
        int keepStart = 7;
        int keepEnd = transformed.length() - 7;
        String finalPath = transformed.substring(keepStart, keepEnd);
        File file = new File(finalPath);
        System.out.println(file.getName());
    }
}