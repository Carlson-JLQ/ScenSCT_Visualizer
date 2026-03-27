// Taint broken by transformation before path sink should not be flagged as path injection.
package scensct.var.neg;

import java.io.File;
import javax.servlet.http.HttpServletRequest;

public class NegCase5_Var4 {
    // Variant 4: Introduce branching and temporary variables, but same net transformation
    public void transformTaint(HttpServletRequest request) {
        String raw = request.getParameter("input");
        String temp = null;
        if (raw != null) {
            temp = "prefix_" + raw;
        } else {
            temp = "prefix_";
        }
        temp = temp + "_suffix";
        // The substring bounds ensure only content between fixed markers is taken
        int suffixLen = "_suffix".length();
        String finalPath = temp.substring("prefix_".length(), temp.length() - suffixLen);
        File file = new File(finalPath);
        System.out.println(file.getName());
    }
}