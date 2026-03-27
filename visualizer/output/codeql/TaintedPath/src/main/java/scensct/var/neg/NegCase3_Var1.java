// Tainted source and path sink present but isolated should not be flagged as path injection.
package scensct.var.neg;

import java.io.File;
import javax.servlet.http.HttpServletRequest;

public class NegCase3_Var1 {
    public void handleRequest(HttpServletRequest request) {
        String userInput = request.getParameter("file");
        String safePath = "default.txt";
        File file = new File(safePath);
        System.out.println(file.getName());
        // Tainted data used in unrelated logging
        logUserAction(userInput);
    }
    
    private void logUserAction(String data) {
        System.out.println("Log: " + data);
    }
}