// User-controlled string from HttpServletRequest.getParameter used directly in File constructor for delete operation should be flagged as path injection.
package scensct.var.pos;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

public class PosCase1_Var3 {
    // Variant 3: Inter-procedural extraction of sink operation
    public void deleteUserFile(HttpServletRequest request) {
        String fileName = request.getParameter("file");
        deleteFileByName(fileName);
    }

    private void deleteFileByName(String name) {
        new File(name).delete(); // [REPORTED LINE]
    }
}