// User-controlled string from HttpServletRequest.getParameter used directly in File constructor for delete operation should be flagged as path injection.
package scensct.var.pos;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

public class PosCase1_Var2 {
    // Variant 2: Control-flow restructuring with always-true condition
    public void deleteUserFile(HttpServletRequest request) {
        String fileName = null;
        if (request != null) {
            fileName = request.getParameter("file");
        } else {
            fileName = "default.txt";
        }
        // The else branch is dead code given the scenario
        new File(fileName).delete(); // [REPORTED LINE]
    }
}