// Taint broken by transformation before path sink should not be flagged as path injection.
package scensct.core.neg;

import java.io.File;
import javax.servlet.http.HttpServletRequest;

public class NegCase5 {
    public void transformTaint(HttpServletRequest request) {
        // Tainted source: user input
        String raw = request.getParameter("input");
        // Taint-breaking transformation: constant concatenation that checker recognizes as safe
        String transformed = "prefix_" + raw + "_suffix";
        // Further operation: substring that may break taint propagation in checker's logic
        String finalPath = transformed.substring(7, transformed.length() - 7);
        // Sink: path operation with transformed data (taint not propagated)
        File file = new File(finalPath);
        System.out.println(file.getName());
    }
}