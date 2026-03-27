// Taint broken by transformation before path sink should not be flagged as path injection.
package scensct.var.neg;

import java.io.File;
import javax.servlet.http.HttpServletRequest;

public class NegCase5_Var3 {
    // Variant 3: Use char array manipulation to achieve same effect
    public void transformTaint(HttpServletRequest request) {
        String raw = request.getParameter("input");
        char[] prefix = "prefix_".toCharArray();
        char[] suffix = "_suffix".toCharArray();
        char[] rawChars = raw.toCharArray();
        char[] combined = new char[prefix.length + rawChars.length + suffix.length];
        System.arraycopy(prefix, 0, combined, 0, prefix.length);
        System.arraycopy(rawChars, 0, combined, prefix.length, rawChars.length);
        System.arraycopy(suffix, 0, combined, prefix.length + rawChars.length, suffix.length);
        // Now extract middle part (which is empty if raw is empty, but still safe)
        int start = 7;
        int end = combined.length - 7;
        String finalPath = new String(combined, start, end - start);
        File file = new File(finalPath);
        System.out.println(file.getName());
    }
}