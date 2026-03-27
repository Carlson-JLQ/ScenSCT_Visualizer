// User-controlled string from HttpServletRequest.getParameter used directly in File constructor for delete operation should be flagged as path injection.
package scensct.var.pos;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

public class PosCase1_Var1 {
    // Variant 1: Lexical refactoring with temporary variable and explicit type
    public void deleteUserFile(HttpServletRequest request) {
        String userInput = request.getParameter("file");
        File targetFile = new File(userInput);
        targetFile.delete(); // [REPORTED LINE]
    }
}