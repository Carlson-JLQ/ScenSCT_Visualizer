// User-controlled string from HttpServletRequest.getParameter used directly in File constructor for delete operation should be flagged as path injection.
package scensct.var.pos;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.nio.file.Paths;

public class PosCase1_Var5 {
    // Variant 5: Equivalent API usage (Paths.get -> toFile)
    public void deleteUserFile(HttpServletRequest request) {
        String fileName = request.getParameter("file");
        Paths.get(fileName).toFile().delete(); // [REPORTED LINE]
    }
}