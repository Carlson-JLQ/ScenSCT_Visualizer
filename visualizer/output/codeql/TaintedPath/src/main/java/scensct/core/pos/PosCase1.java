// User-controlled string from HttpServletRequest.getParameter used directly in File constructor for delete operation should be flagged as path injection.
package scensct.core.pos;

import javax.servlet.http.HttpServletRequest;

public class PosCase1 {
    public void deleteUserFile(HttpServletRequest request) {
        String fileName = request.getParameter("file"); // User-controlled input
        new java.io.File(fileName).delete(); // Direct usage in file operation without sanitization // [REPORTED LINE]
    }
}