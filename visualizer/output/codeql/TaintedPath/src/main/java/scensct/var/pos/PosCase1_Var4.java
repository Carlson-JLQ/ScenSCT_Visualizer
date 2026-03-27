// User-controlled string from HttpServletRequest.getParameter used directly in File constructor for delete operation should be flagged as path injection.
package scensct.var.pos;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

public class PosCase1_Var4 {
    // Variant 4: Try-catch block around sink (no sanitization)
    public void deleteUserFile(HttpServletRequest request) {
        String fileName = request.getParameter("file");
        try {
            new File(fileName).delete(); // [REPORTED LINE]
        } catch (SecurityException e) {
            throw new RuntimeException("Delete failed", e);
        }
    }
}